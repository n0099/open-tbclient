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
import com.baidu.tbadk.core.util.al;
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
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class g implements View.OnClickListener {
    private com.baidu.tbadk.core.util.b.a baD;
    private PersonPolymericModel fIL;
    private com.baidu.tieba.personPolymeric.c.a fJi;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean fJh = true;
    private HttpMessageListener fJj = new HttpMessageListener(CmdConfigHttp.CMD_CHANGE_PORTRAIT) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.bfp();
            }
        }
    };
    private HttpMessageListener fJk = new HttpMessageListener(CmdConfigHttp.CMD_SET_USER_PICS) { // from class: com.baidu.tieba.personPolymeric.b.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.lh(false);
                    return;
                }
                g.this.bfp();
            }
        }
    };
    private Runnable fJl = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.7
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.fIL != null && g.this.fJi != null && g.this.fJi.isHost()) {
                g.this.fIL.resetData();
                g.this.fIL.cM(com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001442));
        }
    };
    private CustomMessageListener fEr = new CustomMessageListener(2001380) { // from class: com.baidu.tieba.personPolymeric.b.g.8
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
        this.fEr.setTag(bdUniqueId);
        this.fJk.setTag(bdUniqueId);
        this.fJj.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.fEr);
        this.mPageContext.registerListener(this.fJk);
        this.mPageContext.registerListener(this.fJj);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.fJi = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.fIL = personPolymericModel;
    }

    public List<com.baidu.adp.widget.ListView.h> bfm() {
        if (this.fJi == null) {
            return null;
        }
        return this.fJi.bfm();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null && bfm() != null) {
            com.baidu.adp.widget.ListView.h hVar = null;
            if (view2.getTag() instanceof com.baidu.tieba.person.b.c) {
                hVar = ((com.baidu.tieba.person.b.c) view2.getTag()).xq();
            } else if (view2.getTag() instanceof com.baidu.tieba.person.b.b) {
                hVar = ((com.baidu.tieba.person.b.b) view2.getTag()).xq();
            }
            int a = v.a(bfm(), hVar);
            if (a >= 0) {
                a(hVar, bfm(), a);
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.h hVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (hVar != null) {
            if (this.fJi != null) {
                this.isHost = this.fJi.isHost();
            }
            if (!l.hg()) {
                this.mPageContext.showToast(d.k.neterror);
            } else if (!this.isHost) {
                if (hVar instanceof com.baidu.tbadk.data.i) {
                    b((com.baidu.tbadk.data.i) hVar, list, i);
                }
            } else if (hVar instanceof com.baidu.tieba.person.data.c) {
                bfn();
            } else if (hVar instanceof com.baidu.tbadk.data.i) {
                com.baidu.tbadk.data.i iVar = (com.baidu.tbadk.data.i) hVar;
                if (iVar.isPortrait()) {
                    a(iVar, list, i);
                } else {
                    c(iVar, list, i);
                }
            }
        }
    }

    private void bfn() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.k.choose_local_photo), this.mPageContext.getString(d.k.change_system_photo)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cc(d.k.operation);
            bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                    g.this.fJh = false;
                    switch (i) {
                        case 0:
                            g.this.aew();
                            break;
                        case 1:
                            g.this.bfr();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tG();
        }
    }

    private void a(final com.baidu.tbadk.data.i iVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.k.hd_photo), this.mPageContext.getString(d.k.change_photo), this.mPageContext.getString(d.k.change_system_photo), this.mPageContext.getString(d.k.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cc(d.k.operation);
            bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view2) {
                    g.this.fJh = true;
                    switch (i2) {
                        case 0:
                            g.this.d(iVar, list, i);
                            break;
                        case 1:
                            g.this.aew();
                            break;
                        case 2:
                            g.this.bfr();
                            break;
                        case 3:
                            TiebaStatic.log(new al("c11616").r("obj_type", 1));
                            g.this.bfs();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tG();
        }
    }

    private void b(final com.baidu.tbadk.data.i iVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(d.k.hd_photo), this.mPageContext.getString(d.k.check_headpendant)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
            bVar.cc(d.k.operation);
            bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personPolymeric.b.g.3
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view2) {
                    switch (i2) {
                        case 0:
                            g.this.d(iVar, list, i);
                            break;
                        case 1:
                            TiebaStatic.log(new al("c11616").r("obj_type", 2));
                            g.this.bfs();
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(this.mPageContext);
            bVar.tG();
        }
    }

    private void c(final com.baidu.tbadk.data.i iVar, final List<com.baidu.adp.widget.ListView.h> list, final int i) {
        String[] strArr = {this.mPageContext.getString(d.k.look_big_photo), this.mPageContext.getString(d.k.set_as_portrait_photo), this.mPageContext.getString(d.k.delete)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.mPageContext.getPageActivity());
        bVar.cc(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personPolymeric.b.g.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i2, View view2) {
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
        bVar.tG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.i iVar, List<com.baidu.adp.widget.ListView.h> list, int i) {
        if (this.mPageContext != null && iVar != null && list != null && !StringUtils.isNull(iVar.Dl())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (com.baidu.adp.widget.ListView.h hVar : list) {
                if (hVar instanceof com.baidu.tbadk.data.i) {
                    com.baidu.tbadk.data.i iVar2 = (com.baidu.tbadk.data.i) hVar;
                    if (iVar2.isPortrait() && !iVar2.Dl().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(h.d(this.mPageContext, iVar2.Dl()));
                    } else {
                        arrayList.add(iVar2.Dl());
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
            if (!v.w(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.fJh)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bfo() {
        if (this.fJi != null && this.fJi.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.Fa().gD(this.fJi.getUserData().getPortrait());
        }
    }

    public void lh(boolean z) {
    }

    public void bfp() {
        com.baidu.adp.lib.g.e.fw().postDelayed(this.fJl, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.fJi != null && this.fJi.getUserData() != null && this.fJi.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            bfo();
        }
    }

    public void bfq() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.9
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.p(str2, g.this.bfm());
                    g.this.lh(true);
                }
            }
        });
    }

    public void aew() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.baD == null) {
                this.baD = new com.baidu.tbadk.core.util.b.a();
            }
            this.baD.wu();
            this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.baD.v(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public void bfr() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, this.fJh)));
        }
    }

    public void bfs() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fJl);
    }
}
