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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
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
    private PersonPolymericModel bJb;
    protected boolean bwa;
    private com.baidu.tieba.personPolymeric.c.a fkq;
    private TbPageContext mF;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean fko = true;
    private boolean fkp = false;
    private boolean fkr = false;
    private HttpMessageListener fks = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.f.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                f.this.aYt();
            }
        }
    };
    private HttpMessageListener fkt = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.f.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    f.this.mF.showToast(setUserPicsResponse.getErrorString());
                    f.this.kw(false);
                    return;
                }
                f.this.aYt();
            }
        }
    };
    private Runnable fku = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.f.7
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.bJb != null && f.this.fkq != null && f.this.fkq.Pk()) {
                f.this.bJb.resetData();
                f.this.bJb.cr(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener fkv = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.f.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                f.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.mF = tbPageContext;
        this.bwa = z;
        this.fkv.setTag(bdUniqueId);
        this.fkt.setTag(bdUniqueId);
        this.fks.setTag(bdUniqueId);
        this.mF.registerListener(this.fkv);
        this.mF.registerListener(this.fkt);
        this.mF.registerListener(this.fks);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fkq = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.bJb = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.f> aYq() {
        if (this.fkq == null) {
            return null;
        }
        return this.fkq.aYq();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aYq() != null) {
            com.baidu.adp.widget.ListView.f fVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                fVar = ((com.baidu.tieba.person.b.b) view.getTag()).xu();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.a) {
                fVar = ((com.baidu.tieba.person.b.a) view.getTag()).xu();
            }
            int a = v.a(aYq(), fVar);
            if (a >= 0) {
                a(fVar, aYq(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.f fVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (fVar != null) {
            if (this.fkq != null) {
                this.bwa = this.fkq.Pk();
            }
            if (!k.hz()) {
                this.mF.showToast(d.l.neterror);
            } else if (!this.bwa) {
                if (fVar instanceof com.baidu.tbadk.data.k) {
                    b((com.baidu.tbadk.data.k) fVar, list, i);
                }
            } else if (fVar instanceof com.baidu.tieba.person.data.a) {
                aYr();
            } else if (fVar instanceof com.baidu.tbadk.data.k) {
                com.baidu.tbadk.data.k kVar = (com.baidu.tbadk.data.k) fVar;
                if (kVar.Cy()) {
                    a(kVar, list, i);
                } else {
                    c(kVar, list, i);
                }
            }
        }
    }

    private void aYr() {
        if (this.mF != null) {
            String[] strArr = {this.mF.getString(d.l.choose_local_photo), this.mF.getString(d.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.personPolymeric.b.f.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    f.this.fko = false;
                    switch (i) {
                        case 0:
                            f.this.Wl();
                            break;
                        case 1:
                            f.this.aYv();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mF);
            bVar.tr();
        }
    }

    private void a(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mF != null) {
            String[] strArr = {this.mF.getString(d.l.hd_photo), this.mF.getString(d.l.change_photo), this.mF.getString(d.l.change_system_photo), this.mF.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.personPolymeric.b.f.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    f.this.fko = true;
                    switch (i2) {
                        case 0:
                            f.this.d(kVar, list, i);
                            break;
                        case 1:
                            f.this.Wl();
                            break;
                        case 2:
                            f.this.aYv();
                            break;
                        case 3:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 1));
                            f.this.aYw();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mF);
            bVar.tr();
        }
    }

    private void b(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mF != null) {
            String[] strArr = {this.mF.getString(d.l.hd_photo), this.mF.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.personPolymeric.b.f.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    switch (i2) {
                        case 0:
                            f.this.d(kVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 2));
                            f.this.aYw();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mF);
            bVar.tr();
        }
    }

    private void c(final com.baidu.tbadk.data.k kVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        String[] strArr = {this.mF.getString(d.l.look_big_photo), this.mF.getString(d.l.set_as_portrait_photo), this.mF.getString(d.l.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mF.getPageActivity());
        bVar.cf(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0046b() { // from class: com.baidu.tieba.personPolymeric.b.f.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        f.this.d(kVar, list, i);
                        break;
                    case 1:
                        g.a(kVar, f.this.mF.getUniqueId());
                        break;
                    case 2:
                        g.a(kVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mF);
        bVar.tr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.k kVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (this.mF != null && kVar != null && list != null && !StringUtils.isNull(kVar.Cx())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tbadk.data.k) {
                    com.baidu.tbadk.data.k kVar2 = (com.baidu.tbadk.data.k) fVar;
                    if (kVar2.Cy()) {
                        arrayList.add(g.g(this.mF, kVar2.Cx()));
                    } else {
                        arrayList.add(kVar2.Cx());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mF.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.mF.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void T(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.v(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mF.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.fko)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aYs() {
        if (this.fkq != null && this.fkq.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Ev().gl(this.fkq.getUserData().getPortrait());
        }
        this.fkp = true;
    }

    public void kw(boolean z) {
        this.fkr = z;
    }

    public void aYt() {
        com.baidu.adp.lib.g.e.fQ().postDelayed(this.fku, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fkq != null && this.fkq.getUserData() != null && this.fkq.Pk() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aYs();
        }
    }

    public void aYu() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.f.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    g.m(str2, f.this.aYq());
                    f.this.kw(true);
                }
            }
        });
    }

    public void Wl() {
        if (this.mF != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mF.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aYv() {
        if (this.mF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mF.getPageActivity(), 12014, this.fko)));
        }
    }

    public void aYw() {
        if (this.mF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mF.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fQ().removeCallbacks(this.fku);
    }
}
