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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.data.j;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {
    private com.baidu.tbadk.core.util.b.a bkp;
    private com.baidu.tieba.personPolymeric.c.a fZI;
    private PersonPolymericModel fZl;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean fZH = true;
    private HttpMessageListener fZJ = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.bkU();
            }
        }
    };
    private HttpMessageListener fZK = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.ly(false);
                    return;
                }
                g.this.bkU();
            }
        }
    };
    private Runnable fZL = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.6
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fZl != null && g.this.fZI != null && g.this.fZI.isHost()) {
                g.this.fZl.resetData();
                g.this.fZl.cN(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001442));
        }
    };
    private CustomMessageListener fUP = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.b.g.7
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
        this.fUP.setTag(bdUniqueId);
        this.fZK.setTag(bdUniqueId);
        this.fZJ.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.fUP);
        this.mPageContext.registerListener(this.fZK);
        this.mPageContext.registerListener(this.fZJ);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fZI = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.fZl = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.h> bkR() {
        if (this.fZI == null) {
            return null;
        }
        return this.fZI.bkR();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && bkR() != null) {
            com.baidu.adp.widget.ListView.h hVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                hVar = ((com.baidu.tieba.person.b.c) view.getTag()).Bi();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                hVar = ((com.baidu.tieba.person.b.b) view.getTag()).Bi();
            }
            int a = w.a(bkR(), hVar);
            if (a >= 0) {
                a(hVar, bkR(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.h hVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (hVar != null) {
            if (this.fZI != null) {
                this.isHost = this.fZI.isHost();
            }
            if (!l.jU()) {
                this.mPageContext.showToast(d.k.neterror);
            } else if (!this.isHost) {
                if (hVar instanceof j) {
                    c((j) hVar, list, i);
                }
            } else if (hVar instanceof com.baidu.tieba.person.data.c) {
                bkS();
            } else if (hVar instanceof j) {
                j jVar = (j) hVar;
                if (jVar.isPortrait()) {
                    a(jVar, list, i);
                } else {
                    b(jVar, list, i);
                }
            }
        }
    }

    private void bkS() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.k.choose_local_photo), this.mPageContext.getString(d.k.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.k.operation);
            bVar.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.fZH = false;
                    switch (i) {
                        case 0:
                            g.this.ahm();
                            break;
                        case 1:
                            g.this.bkW();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xq();
        }
    }

    private void a(final j jVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.k.hd_photo), this.mPageContext.getString(d.k.change_photo), this.mPageContext.getString(d.k.change_system_photo), this.mPageContext.getString(d.k.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cg(d.k.operation);
            bVar.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.fZH = true;
                    switch (i2) {
                        case 0:
                            g.this.c(jVar, list, i);
                            break;
                        case 1:
                            g.this.ahm();
                            break;
                        case 2:
                            g.this.bkW();
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").r("obj_type", 1));
                            g.this.bkX();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xq();
        }
    }

    private void b(final j jVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        String[] strArr = {this.mPageContext.getString(d.k.look_big_photo), this.mPageContext.getString(d.k.set_as_portrait_photo), this.mPageContext.getString(d.k.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
        bVar.cg(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.c(jVar, list, i);
                        break;
                    case 1:
                        h.a(jVar, g.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        h.a(jVar, list);
                        break;
                }
                bVar2.dismiss();
            }
        });
        bVar.d(this.mPageContext);
        bVar.xq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (this.mPageContext != null && jVar != null && list != null && !StringUtils.isNull(jVar.He())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof j) {
                    j jVar2 = (j) hVar;
                    if (jVar2.isPortrait() && !jVar2.He().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(h.d(this.mPageContext, jVar2.He()));
                    } else {
                        arrayList.add(jVar2.He());
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

    public void O(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!w.A(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.fZH)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bkT() {
        if (this.fZI != null && this.fZI.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.IV().hf(this.fZI.getUserData().getPortrait());
        }
    }

    public void ly(boolean z) {
    }

    public void bkU() {
        com.baidu.adp.lib.g.e.im().postDelayed(this.fZL, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fZI != null && this.fZI.getUserData() != null && this.fZI.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            bkT();
        }
    }

    public void bkV() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.8
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.p(str2, g.this.bkR());
                    g.this.ly(true);
                }
            }
        });
    }

    public void ahm() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.bkp == null) {
                this.bkp = new com.baidu.tbadk.core.util.b.a();
            }
            this.bkp.Aj();
            this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bkp.u(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public void bkW() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, this.fZH)));
        }
    }

    public void bkX() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fZL);
    }
}
