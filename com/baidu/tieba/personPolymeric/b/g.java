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
import com.baidu.tieba.f;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {
    private com.baidu.tbadk.core.util.b.a bkZ;
    private PersonPolymericModel fZD;
    private com.baidu.tieba.personPolymeric.c.a fZZ;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean fZY = true;
    private HttpMessageListener gaa = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.bjl();
            }
        }
    };
    private HttpMessageListener gab = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.lk(false);
                    return;
                }
                g.this.bjl();
            }
        }
    };
    private Runnable gac = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.6
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fZD != null && g.this.fZZ != null && g.this.fZZ.isHost()) {
                g.this.fZD.resetData();
                g.this.fZD.cJ(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001442));
        }
    };
    private CustomMessageListener fUY = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.b.g.7
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
        this.fUY.setTag(bdUniqueId);
        this.gab.setTag(bdUniqueId);
        this.gaa.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.fUY);
        this.mPageContext.registerListener(this.gab);
        this.mPageContext.registerListener(this.gaa);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fZZ = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.fZD = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.h> bji() {
        if (this.fZZ == null) {
            return null;
        }
        return this.fZZ.bji();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && bji() != null) {
            com.baidu.adp.widget.ListView.h hVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                hVar = ((com.baidu.tieba.person.b.c) view.getTag()).AW();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                hVar = ((com.baidu.tieba.person.b.b) view.getTag()).AW();
            }
            int a = w.a(bji(), hVar);
            if (a >= 0) {
                a(hVar, bji(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.h hVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (hVar != null) {
            if (this.fZZ != null) {
                this.isHost = this.fZZ.isHost();
            }
            if (!l.jV()) {
                this.mPageContext.showToast(f.j.neterror);
            } else if (!this.isHost) {
                if (hVar instanceof j) {
                    c((j) hVar, list, i);
                }
            } else if (hVar instanceof com.baidu.tieba.person.data.c) {
                bjj();
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

    private void bjj() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(f.j.choose_local_photo), this.mPageContext.getString(f.j.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.ci(f.j.operation);
            bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    g.this.fZY = false;
                    switch (i) {
                        case 0:
                            g.this.ahN();
                            break;
                        case 1:
                            g.this.bjn();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xh();
        }
    }

    private void a(final j jVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(f.j.hd_photo), this.mPageContext.getString(f.j.change_photo), this.mPageContext.getString(f.j.change_system_photo), this.mPageContext.getString(f.j.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.ci(f.j.operation);
            bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view) {
                    g.this.fZY = true;
                    switch (i2) {
                        case 0:
                            g.this.c(jVar, list, i);
                            break;
                        case 1:
                            g.this.ahN();
                            break;
                        case 2:
                            g.this.bjn();
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").r("obj_type", 1));
                            g.this.bjo();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.xh();
        }
    }

    private void b(final j jVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        String[] strArr = {this.mPageContext.getString(f.j.look_big_photo), this.mPageContext.getString(f.j.set_as_portrait_photo), this.mPageContext.getString(f.j.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
        bVar.ci(f.j.operation);
        bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
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
        bVar.xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (this.mPageContext != null && jVar != null && list != null && !StringUtils.isNull(jVar.Ha())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof j) {
                    j jVar2 = (j) hVar;
                    if (jVar2.isPortrait() && !jVar2.Ha().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(h.d(this.mPageContext, jVar2.Ha()));
                    } else {
                        arrayList.add(jVar2.Ha());
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
            if (!w.z(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.fZY)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bjk() {
        if (this.fZZ != null && this.fZZ.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.IQ().hb(this.fZZ.getUserData().getPortrait());
        }
    }

    public void lk(boolean z) {
    }

    public void bjl() {
        com.baidu.adp.lib.g.e.in().postDelayed(this.gac, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fZZ != null && this.fZZ.getUserData() != null && this.fZZ.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            bjk();
        }
    }

    public void bjm() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.8
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.o(str2, g.this.bji());
                    g.this.lk(true);
                }
            }
        });
    }

    public void ahN() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.bkZ == null) {
                this.bkZ = new com.baidu.tbadk.core.util.b.a();
            }
            this.bkZ.zW();
            this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bkZ.u(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public void bjn() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, this.fZY)));
        }
    }

    public void bjo() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gac);
    }
}
