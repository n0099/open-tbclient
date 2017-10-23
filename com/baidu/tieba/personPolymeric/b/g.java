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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.frameworkData.IntentAction;
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
public class g implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.c.a ffC;
    private PersonPolymericModel ffg;
    protected boolean isHost;
    private TbPageContext mH;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean ffA = true;
    private boolean ffB = false;
    private boolean ffD = false;
    private HttpMessageListener ffE = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.aWK();
            }
        }
    };
    private HttpMessageListener ffF = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mH.showToast(setUserPicsResponse.getErrorString());
                    g.this.km(false);
                    return;
                }
                g.this.aWK();
            }
        }
    };
    private Runnable ffG = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.7
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.ffg != null && g.this.ffC != null && g.this.ffC.isHost()) {
                g.this.ffg.resetData();
                g.this.ffg.cq(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener faB = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                g.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.mH = tbPageContext;
        this.isHost = z;
        this.faB.setTag(bdUniqueId);
        this.ffF.setTag(bdUniqueId);
        this.ffE.setTag(bdUniqueId);
        this.mH.registerListener(this.faB);
        this.mH.registerListener(this.ffF);
        this.mH.registerListener(this.ffE);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.ffC = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.ffg = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.f> aWH() {
        if (this.ffC == null) {
            return null;
        }
        return this.ffC.aWH();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && aWH() != null) {
            com.baidu.adp.widget.ListView.f fVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                fVar = ((com.baidu.tieba.person.b.c) view.getTag()).wM();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                fVar = ((com.baidu.tieba.person.b.b) view.getTag()).wM();
            }
            int a = v.a(aWH(), fVar);
            if (a >= 0) {
                a(fVar, aWH(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.f fVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (fVar != null) {
            if (this.ffC != null) {
                this.isHost = this.ffC.isHost();
            }
            if (!l.hy()) {
                this.mH.showToast(d.l.neterror);
            } else if (!this.isHost) {
                if (fVar instanceof com.baidu.tbadk.data.j) {
                    b((com.baidu.tbadk.data.j) fVar, list, i);
                }
            } else if (fVar instanceof com.baidu.tieba.person.data.c) {
                aWI();
            } else if (fVar instanceof com.baidu.tbadk.data.j) {
                com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) fVar;
                if (jVar.BW()) {
                    a(jVar, list, i);
                } else {
                    c(jVar, list, i);
                }
            }
        }
    }

    private void aWI() {
        if (this.mH != null) {
            String[] strArr = {this.mH.getString(d.l.choose_local_photo), this.mH.getString(d.l.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mH.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.ffA = false;
                    switch (i) {
                        case 0:
                            g.this.WB();
                            break;
                        case 1:
                            g.this.aWM();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mH);
            bVar.te();
        }
    }

    private void a(final com.baidu.tbadk.data.j jVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mH != null) {
            String[] strArr = {this.mH.getString(d.l.hd_photo), this.mH.getString(d.l.change_photo), this.mH.getString(d.l.change_system_photo), this.mH.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mH.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.ffA = true;
                    switch (i2) {
                        case 0:
                            g.this.d(jVar, list, i);
                            break;
                        case 1:
                            g.this.WB();
                            break;
                        case 2:
                            g.this.aWM();
                            break;
                        case 3:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 1));
                            g.this.aWN();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mH);
            bVar.te();
        }
    }

    private void b(final com.baidu.tbadk.data.j jVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        if (this.mH != null) {
            String[] strArr = {this.mH.getString(d.l.hd_photo), this.mH.getString(d.l.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mH.getPageActivity());
            bVar.cf(d.l.operation);
            bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    switch (i2) {
                        case 0:
                            g.this.d(jVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new ak("c11616").r("obj_type", 2));
                            g.this.aWN();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mH);
            bVar.te();
        }
    }

    private void c(final com.baidu.tbadk.data.j jVar, final List<com.baidu.adp.widget.ListView.f> list, final int i) {
        String[] strArr = {this.mH.getString(d.l.look_big_photo), this.mH.getString(d.l.set_as_portrait_photo), this.mH.getString(d.l.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mH.getPageActivity());
        bVar.cf(d.l.operation);
        bVar.a(strArr, new b.InterfaceC0047b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.d(jVar, list, i);
                        break;
                    case 1:
                        h.a(jVar, g.this.mH.getUniqueId());
                        break;
                    case 2:
                        h.a(jVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mH);
        bVar.te();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.j jVar, List<com.baidu.adp.widget.ListView.f> list, int i) {
        if (this.mH != null && jVar != null && list != null && !StringUtils.isNull(jVar.BV())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.f fVar : list) {
                if (fVar instanceof com.baidu.tbadk.data.j) {
                    com.baidu.tbadk.data.j jVar2 = (com.baidu.tbadk.data.j) fVar;
                    if (jVar2.BW()) {
                        arrayList.add(h.g(this.mH, jVar2.BV()));
                    } else {
                        arrayList.add(jVar2.BV());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mH.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.mH.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true)));
        }
    }

    public void P(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.u(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mH.getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.ffA)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aWJ() {
        if (this.ffC != null && this.ffC.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.DT().ge(this.ffC.getUserData().getPortrait());
        }
        this.ffB = true;
    }

    public void km(boolean z) {
        this.ffD = z;
    }

    public void aWK() {
        com.baidu.adp.lib.g.e.fP().postDelayed(this.ffG, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.ffC != null && this.ffC.getUserData() != null && this.ffC.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            aWJ();
        }
    }

    public void aWL() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.o(str2, g.this.aWH());
                    g.this.km(true);
                }
            }
        });
    }

    public void WB() {
        if (this.mH != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mH.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
            albumActivityConfig.setRequestCode(12002);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
        }
    }

    public void aWM() {
        if (this.mH != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mH.getPageActivity(), 12014, this.ffA)));
        }
    }

    public void aWN() {
        if (this.mH != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mH.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.ffG);
    }
}
