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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.k;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {
    private com.baidu.tbadk.core.util.b.a bvI;
    private PersonPolymericModel gpV;
    private com.baidu.tieba.personPolymeric.c.a gqr;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean gqq = true;
    private HttpMessageListener gqs = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.bos();
            }
        }
    };
    private HttpMessageListener gqt = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.mi(false);
                    return;
                }
                g.this.bos();
            }
        }
    };
    private Runnable gqu = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.6
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.gpV != null && g.this.gqr != null && g.this.gqr.isHost()) {
                g.this.gpV.resetData();
                g.this.gpV.cP(com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001442));
        }
    };
    private CustomMessageListener glp = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.b.g.7
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
        this.glp.setTag(bdUniqueId);
        this.gqt.setTag(bdUniqueId);
        this.gqs.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.glp);
        this.mPageContext.registerListener(this.gqt);
        this.mPageContext.registerListener(this.gqs);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.gqr = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.gpV = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.h> bop() {
        if (this.gqr == null) {
            return null;
        }
        return this.gqr.bop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && bop() != null) {
            com.baidu.adp.widget.ListView.h hVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                hVar = ((com.baidu.tieba.person.b.c) view.getTag()).Ex();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                hVar = ((com.baidu.tieba.person.b.b) view.getTag()).Ex();
            }
            int a = v.a(bop(), hVar);
            if (a >= 0) {
                a(hVar, bop(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.h hVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (hVar != null) {
            if (this.gqr != null) {
                this.isHost = this.gqr.isHost();
            }
            if (!l.lm()) {
                this.mPageContext.showToast(e.j.neterror);
            } else if (!this.isHost) {
                if (hVar instanceof k) {
                    c((k) hVar, list, i);
                }
            } else if (hVar instanceof com.baidu.tieba.person.data.c) {
                boq();
            } else if (hVar instanceof k) {
                k kVar = (k) hVar;
                if (kVar.isPortrait()) {
                    a(kVar, list, i);
                } else {
                    b(kVar, list, i);
                }
            }
        }
    }

    private void boq() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(e.j.choose_local_photo), this.mPageContext.getString(e.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cQ(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.gqq = false;
                    switch (i) {
                        case 0:
                            g.this.amD();
                            break;
                        case 1:
                            g.this.bou();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AE();
        }
    }

    private void a(final k kVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(e.j.hd_photo), this.mPageContext.getString(e.j.change_photo), this.mPageContext.getString(e.j.change_system_photo), this.mPageContext.getString(e.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cQ(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.gqq = true;
                    switch (i2) {
                        case 0:
                            g.this.c(kVar, list, i);
                            break;
                        case 1:
                            g.this.amD();
                            break;
                        case 2:
                            g.this.bou();
                            break;
                        case 3:
                            TiebaStatic.log(new am("c11616").x("obj_type", 1));
                            g.this.bov();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.AE();
        }
    }

    private void b(final k kVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        String[] strArr = {this.mPageContext.getString(e.j.look_big_photo), this.mPageContext.getString(e.j.set_as_portrait_photo), this.mPageContext.getString(e.j.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
        bVar.cQ(e.j.operation);
        bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.c(kVar, list, i);
                        break;
                    case 1:
                        h.a(kVar, g.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        h.a(kVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mPageContext);
        bVar.AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(k kVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (this.mPageContext != null && kVar != null && list != null && !StringUtils.isNull(kVar.KB())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof k) {
                    k kVar2 = (k) hVar;
                    if (kVar2.isPortrait() && !kVar2.KB().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(h.d(this.mPageContext, kVar2.KB()));
                    } else {
                        arrayList.add(kVar2.KB());
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

    public void S(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.I(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.gqq)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bor() {
        if (this.gqr != null && this.gqr.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Mq().hM(this.gqr.getUserData().getPortrait());
        }
    }

    public void mi(boolean z) {
    }

    public void bos() {
        com.baidu.adp.lib.g.e.jG().postDelayed(this.gqu, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.gqr != null && this.gqr.getUserData() != null && this.gqr.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            bor();
        }
    }

    public void bot() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.8
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.p(str2, g.this.bop());
                    g.this.mi(true);
                }
            }
        });
    }

    public void amD() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.bvI == null) {
                this.bvI = new com.baidu.tbadk.core.util.b.a();
            }
            this.bvI.Dp();
            this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bvI.A(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public void bou() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, this.gqq)));
        }
    }

    public void bov() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gqu);
    }
}
