package com.baidu.tieba.personPolymeric.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private PersonPolymericModel bFp;
    protected boolean buA;
    private com.baidu.tieba.personPolymeric.c.a flb;
    private PersonChangeData mPersonChangeData;
    private TbPageContext oV;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean fkZ = true;
    private boolean fla = false;
    private boolean flc = false;
    private HttpMessageListener fld = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                f.this.aZb();
            }
        }
    };
    private HttpMessageListener fle = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    f.this.oV.showToast(setUserPicsResponse.getErrorString());
                    f.this.kt(false);
                    return;
                }
                f.this.aZb();
            }
        }
    };
    private Runnable flf = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.f.7
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.bFp != null && f.this.flb != null && f.this.flb.OS()) {
                f.this.bFp.resetData();
                f.this.bFp.cw(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener flg = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                f.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.oV = tbPageContext;
        this.buA = z;
        this.flg.setTag(bdUniqueId);
        this.fle.setTag(bdUniqueId);
        this.fld.setTag(bdUniqueId);
        this.oV.registerListener(this.flg);
        this.oV.registerListener(this.fle);
        this.oV.registerListener(this.fld);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.flb = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.bFp = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.f> aYY() {
        if (this.flb == null) {
            return null;
        }
        return this.flb.aYY();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aYY() != null) {
            com.baidu.adp.widget.ListView.f fVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                fVar = ((com.baidu.tieba.person.b.b) view.getTag()).xs();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.a) {
                fVar = ((com.baidu.tieba.person.b.a) view.getTag()).xs();
            }
            int a = u.a(aYY(), fVar);
            if (a >= 0) {
                a(fVar, aYY(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.f fVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (fVar != null) {
            if (this.flb != null) {
                this.buA = this.flb.OS();
            }
            if (!k.hI()) {
                this.oV.showToast(d.l.neterror);
            } else if (!this.buA) {
                if (fVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) fVar, list, i);
                }
            } else if (fVar instanceof com.baidu.tieba.person.data.a) {
                aYZ();
            } else if (fVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) fVar;
                if (kVar.CD()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aYZ() {
        if (this.oV != null) {
            String[] strArr = {this.oV.getString(d.l.choose_local_photo), this.oV.getString(d.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oV.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    f.this.fkZ = false;
                    switch (i) {
                        case 0:
                            f.this.Vc();
                            break;
                        case 1:
                            f.this.aZd();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oV);
            bVar.tu();
        }
    }

    private void a(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.oV != null) {
            String[] strArr = {this.oV.getString(d.l.hd_photo), this.oV.getString(d.l.change_photo), this.oV.getString(d.l.change_system_photo), this.oV.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oV.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    f.this.fkZ = true;
                    switch (i2) {
                        case 0:
                            f.this.d(kVar, list, i);
                            break;
                        case 1:
                            f.this.Vc();
                            break;
                        case 2:
                            f.this.aZd();
                            break;
                        case 3:
                            TiebaStatic.log(new aj("c11616").r("obj_type", 1));
                            f.this.aZe();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oV);
            bVar.tu();
        }
    }

    private void b(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.oV != null) {
            String[] strArr = {this.oV.getString(d.l.hd_photo), this.oV.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oV.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    switch (i2) {
                        case 0:
                            f.this.d(kVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new aj("c11616").r("obj_type", 2));
                            f.this.aZe();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oV);
            bVar.tu();
        }
    }

    private void c(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        String[] strArr = {this.oV.getString(d.l.look_big_photo), this.oV.getString(d.l.set_as_portrait_photo), this.oV.getString(d.l.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oV.getPageActivity());
        bVar.cf(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        f.this.d(kVar, list, i);
                        break;
                    case 1:
                        g.a(kVar, f.this.oV.getUniqueId());
                        break;
                    case 2:
                        g.a(kVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.oV);
        bVar.tu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (this.oV != null && kVar != null && list != null && !StringUtils.isNull(kVar.CC())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) fVar;
                    if (kVar2.CD()) {
                        arrayList.add(g.g(this.oV, kVar2.CC()));
                    } else {
                        arrayList.add(kVar2.CC());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.oV.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.oV.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!u.v(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.oV.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.fkZ)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aZa() {
        if (this.flb != null && this.flb.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Ex().gm(this.flb.getUserData().getPortrait());
        }
        this.fla = true;
    }

    public void kt(boolean z) {
        this.flc = z;
    }

    public void aZb() {
        com.baidu.adp.lib.g.e.ga().postDelayed(this.flf, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.flb != null && this.flb.getUserData() != null && this.flb.OS() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aZa();
        }
    }

    public void aZc() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    g.n(str2, f.this.aYY());
                    f.this.kt(true);
                }
            }
        });
    }

    public void Vc() {
        if (this.oV != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.oV.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aZd() {
        if (this.oV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.oV.getPageActivity(), 12014, this.fkZ)));
        }
    }

    public void aZe() {
        if (this.oV != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.oV.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.flf);
    }
}
