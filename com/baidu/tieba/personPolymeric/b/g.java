package com.baidu.tieba.personPolymeric.b;

import android.app.Activity;
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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.b;
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
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {
    private com.baidu.tbadk.core.util.b.a bQQ;
    private com.baidu.tieba.personPolymeric.c.a goD;
    private PersonPolymericModel goi;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean goC = true;
    private HttpMessageListener goE = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.bkl();
            }
        }
    };
    private HttpMessageListener goF = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.lC(false);
                    return;
                }
                g.this.bkl();
            }
        }
    };
    private Runnable goG = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.7
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.goi != null && g.this.goD != null && g.this.goD.isHost()) {
                g.this.goi.resetData();
                g.this.goi.cI(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001442));
        }
    };
    private CustomMessageListener gjP = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.b.g.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                g.this.a((PersonChangeData) customResponsedMessage.getData());
            }
        }
    };

    public g(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        this.mPageContext = tbPageContext;
        this.isHost = z;
        this.gjP.setTag(bdUniqueId);
        this.goF.setTag(bdUniqueId);
        this.goE.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.gjP);
        this.mPageContext.registerListener(this.goF);
        this.mPageContext.registerListener(this.goE);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.goD = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.goi = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.i> bki() {
        if (this.goD == null) {
            return null;
        }
        return this.goD.bki();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && bki() != null) {
            com.baidu.adp.widget.ListView.i iVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                iVar = ((com.baidu.tieba.person.b.c) view.getTag()).EG();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                iVar = ((com.baidu.tieba.person.b.b) view.getTag()).EG();
            }
            int a = v.a(bki(), iVar);
            if (a >= 0) {
                a(iVar, bki(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.i iVar, List<com.baidu.adp.widget.ListView.i> list, int i) {
        if (iVar != null) {
            if (this.goD != null) {
                this.isHost = this.goD.isHost();
            }
            if (!l.pa()) {
                this.mPageContext.showToast(d.j.neterror);
            } else if (!this.isHost) {
                if (iVar instanceof com.baidu.tbadk.data.i) {
                    b((com.baidu.tbadk.data.i) iVar, list, i);
                }
            } else if (iVar instanceof com.baidu.tieba.person.data.c) {
                bkj();
            } else if (iVar instanceof com.baidu.tbadk.data.i) {
                com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) iVar;
                if (iVar2.isPortrait()) {
                    a(iVar2, list, i);
                } else {
                    c(iVar2, list, i);
                }
            }
        }
    }

    private void bkj() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.choose_local_photo), this.mPageContext.getString(d.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.goC = false;
                    switch (i) {
                        case 0:
                            g.this.akr();
                            break;
                        case 1:
                            g.this.bkn();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    private void a(final com.baidu.tbadk.data.i iVar, final List<com.baidu.adp.widget.ListView.i> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.hd_photo), this.mPageContext.getString(d.j.change_photo), this.mPageContext.getString(d.j.change_system_photo), this.mPageContext.getString(d.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.goC = true;
                    switch (i2) {
                        case 0:
                            g.this.d(iVar, list, i);
                            break;
                        case 1:
                            g.this.akr();
                            break;
                        case 2:
                            g.this.bkn();
                            break;
                        case 3:
                            TiebaStatic.log(new ak("c11616").s("obj_type", 1));
                            g.this.bko();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    private void b(final com.baidu.tbadk.data.i iVar, final List<com.baidu.adp.widget.ListView.i> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.j.hd_photo), this.mPageContext.getString(d.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.fe(d.j.operation);
            bVar.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    switch (i2) {
                        case 0:
                            g.this.d(iVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new ak("c11616").s("obj_type", 2));
                            g.this.bko();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AX();
        }
    }

    private void c(final com.baidu.tbadk.data.i iVar, final List<com.baidu.adp.widget.ListView.i> list, final int i) {
        String[] strArr = {this.mPageContext.getString(d.j.look_big_photo), this.mPageContext.getString(d.j.set_as_portrait_photo), this.mPageContext.getString(d.j.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
        bVar.fe(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.d(iVar, list, i);
                        break;
                    case 1:
                        h.a(iVar, g.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        h.a(iVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mPageContext);
        bVar.AX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.i iVar, List<com.baidu.adp.widget.ListView.i> list, int i) {
        if (this.mPageContext != null && iVar != null && list != null && !StringUtils.isNull(iVar.KF())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.i iVar2 : list) {
                if (iVar2 instanceof com.baidu.tbadk.data.i) {
                    com.baidu.tbadk.data.i iVar3 = (com.baidu.tbadk.data.i) iVar2;
                    if (iVar3.isPortrait()) {
                        arrayList.add(h.e(this.mPageContext, iVar3.KF()));
                    } else {
                        arrayList.add(iVar3.KF());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mPageContext.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true).setIsShowHost(false)));
        }
    }

    public void P(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.E(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.goC)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bkk() {
        if (this.goD != null && this.goD.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Mx().gM(this.goD.getUserData().getPortrait());
        }
    }

    public void lC(boolean z) {
    }

    public void bkl() {
        com.baidu.adp.lib.g.e.ns().postDelayed(this.goG, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.goD != null && this.goD.getUserData() != null && this.goD.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            bkk();
        }
    }

    public void bkm() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.o(str2, g.this.bki());
                    g.this.lC(true);
                }
            }
        });
    }

    public void akr() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.bQQ == null) {
                this.bQQ = new com.baidu.tbadk.core.util.b.a();
            }
            this.bQQ.DI();
            this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bQQ.v(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public void bkn() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, this.goC)));
        }
    }

    public void bko() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.goG);
    }
}
