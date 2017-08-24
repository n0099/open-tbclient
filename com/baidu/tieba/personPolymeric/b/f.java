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
    private PersonPolymericModel bFq;
    protected boolean buB;
    private com.baidu.tieba.personPolymeric.c.a fld;
    private PersonChangeData mPersonChangeData;
    private TbPageContext oW;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean flb = true;
    private boolean flc = false;
    private boolean fle = false;
    private HttpMessageListener flf = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                f.this.aYW();
            }
        }
    };
    private HttpMessageListener flg = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    f.this.oW.showToast(setUserPicsResponse.getErrorString());
                    f.this.kt(false);
                    return;
                }
                f.this.aYW();
            }
        }
    };
    private Runnable flh = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.f.7
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.bFq != null && f.this.fld != null && f.this.fld.OR()) {
                f.this.bFq.resetData();
                f.this.bFq.cw(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener fli = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                f.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.oW = tbPageContext;
        this.buB = z;
        this.fli.setTag(bdUniqueId);
        this.flg.setTag(bdUniqueId);
        this.flf.setTag(bdUniqueId);
        this.oW.registerListener(this.fli);
        this.oW.registerListener(this.flg);
        this.oW.registerListener(this.flf);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fld = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.bFq = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.f> aYT() {
        if (this.fld == null) {
            return null;
        }
        return this.fld.aYT();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aYT() != null) {
            com.baidu.adp.widget.ListView.f fVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                fVar = ((com.baidu.tieba.person.b.b) view.getTag()).xs();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.a) {
                fVar = ((com.baidu.tieba.person.b.a) view.getTag()).xs();
            }
            int a = u.a(aYT(), fVar);
            if (a >= 0) {
                a(fVar, aYT(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.f fVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (fVar != null) {
            if (this.fld != null) {
                this.buB = this.fld.OR();
            }
            if (!k.hI()) {
                this.oW.showToast(d.l.neterror);
            } else if (!this.buB) {
                if (fVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) fVar, list, i);
                }
            } else if (fVar instanceof com.baidu.tieba.person.data.a) {
                aYU();
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

    private void aYU() {
        if (this.oW != null) {
            String[] strArr = {this.oW.getString(d.l.choose_local_photo), this.oW.getString(d.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oW.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    f.this.flb = false;
                    switch (i) {
                        case 0:
                            f.this.UZ();
                            break;
                        case 1:
                            f.this.aYY();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oW);
            bVar.tv();
        }
    }

    private void a(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.oW != null) {
            String[] strArr = {this.oW.getString(d.l.hd_photo), this.oW.getString(d.l.change_photo), this.oW.getString(d.l.change_system_photo), this.oW.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oW.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    f.this.flb = true;
                    switch (i2) {
                        case 0:
                            f.this.d(kVar, list, i);
                            break;
                        case 1:
                            f.this.UZ();
                            break;
                        case 2:
                            f.this.aYY();
                            break;
                        case 3:
                            TiebaStatic.log(new aj("c11616").r("obj_type", 1));
                            f.this.aYZ();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oW);
            bVar.tv();
        }
    }

    private void b(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.oW != null) {
            String[] strArr = {this.oW.getString(d.l.hd_photo), this.oW.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oW.getPageActivity());
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
                            f.this.aYZ();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.oW);
            bVar.tv();
        }
    }

    private void c(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        String[] strArr = {this.oW.getString(d.l.look_big_photo), this.oW.getString(d.l.set_as_portrait_photo), this.oW.getString(d.l.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.oW.getPageActivity());
        bVar.cf(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0043b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        f.this.d(kVar, list, i);
                        break;
                    case 1:
                        g.a(kVar, f.this.oW.getUniqueId());
                        break;
                    case 2:
                        g.a(kVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.oW);
        bVar.tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (this.oW != null && kVar != null && list != null && !StringUtils.isNull(kVar.CC())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) fVar;
                    if (kVar2.CD()) {
                        arrayList.add(g.g(this.oW, kVar2.CC()));
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
            this.oW.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.oW.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!u.v(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.oW.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.flb)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aYV() {
        if (this.fld != null && this.fld.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Ex().gq(this.fld.getUserData().getPortrait());
        }
        this.flc = true;
    }

    public void kt(boolean z) {
        this.fle = z;
    }

    public void aYW() {
        com.baidu.adp.lib.g.e.ga().postDelayed(this.flh, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fld != null && this.fld.getUserData() != null && this.fld.OR() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aYV();
        }
    }

    public void aYX() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    g.m(str2, f.this.aYT());
                    f.this.kt(true);
                }
            }
        });
    }

    public void UZ() {
        if (this.oW != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.oW.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aYY() {
        if (this.oW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.oW.getPageActivity(), 12014, this.flb)));
        }
    }

    public void aYZ() {
        if (this.oW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.oW.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.ga().removeCallbacks(this.flh);
    }
}
