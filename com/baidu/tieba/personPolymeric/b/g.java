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
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.person.ChangePortraitResponse;
import com.baidu.tieba.person.SetUserPicsResponse;
import com.baidu.tieba.person.a;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class g implements View.OnClickListener {
    private com.baidu.tieba.personPolymeric.c.a iqJ;
    private PersonPolymericModel iqn;
    protected boolean isHost;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private PersonChangeData mPersonChangeData;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private boolean iqI = true;
    private HttpMessageListener iqK = new HttpMessageListener(1003063) { // from class: com.baidu.tieba.personPolymeric.b.g.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChangePortraitResponse) && ((ChangePortraitResponse) httpResponsedMessage).getErrCode() == 0) {
                g.this.caY();
            }
        }
    };
    private HttpMessageListener iqL = new HttpMessageListener(1003064) { // from class: com.baidu.tieba.personPolymeric.b.g.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof SetUserPicsResponse)) {
                SetUserPicsResponse setUserPicsResponse = (SetUserPicsResponse) httpResponsedMessage;
                if (setUserPicsResponse.getErrCode() != 0) {
                    g.this.mPageContext.showToast(setUserPicsResponse.getErrorString());
                    g.this.pB(false);
                    return;
                }
                g.this.caY();
            }
        }
    };
    private Runnable iqM = new Runnable() { // from class: com.baidu.tieba.personPolymeric.b.g.6
        @Override // java.lang.Runnable
        public void run() {
            if (g.this.iqn != null && g.this.iqJ != null && g.this.iqJ.isHost()) {
                g.this.iqn.resetData();
                g.this.iqn.dL(com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED));
        }
    };
    private CustomMessageListener ily = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_DATA_CHANGED) { // from class: com.baidu.tieba.personPolymeric.b.g.7
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
        this.ily.setTag(bdUniqueId);
        this.iqL.setTag(bdUniqueId);
        this.iqK.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.ily);
        this.mPageContext.registerListener(this.iqL);
        this.mPageContext.registerListener(this.iqK);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar) {
        this.iqJ = aVar;
    }

    public void a(PersonPolymericModel personPolymericModel) {
        this.iqn = personPolymericModel;
    }

    public List<m> caV() {
        if (this.iqJ == null) {
            return null;
        }
        return this.iqJ.caV();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && caV() != null) {
            m mVar = null;
            if (view.getTag() instanceof com.baidu.tieba.person.b.c) {
                mVar = ((com.baidu.tieba.person.b.c) view.getTag()).aok();
            } else if (view.getTag() instanceof com.baidu.tieba.person.b.b) {
                mVar = ((com.baidu.tieba.person.b.b) view.getTag()).aok();
            }
            int position = v.getPosition(caV(), mVar);
            if (position >= 0) {
                a(mVar, caV(), position);
            }
        }
    }

    public void a(m mVar, List<m> list, int i) {
        if (mVar != null) {
            if (this.iqJ != null) {
                this.isHost = this.iqJ.isHost();
            }
            if (!l.isNetOk()) {
                this.mPageContext.showToast(R.string.neterror);
            } else if (!this.isHost) {
                if (mVar instanceof com.baidu.tbadk.data.m) {
                    c((com.baidu.tbadk.data.m) mVar, list, i);
                }
            } else if (mVar instanceof com.baidu.tieba.person.data.c) {
                caW();
            } else if (mVar instanceof com.baidu.tbadk.data.m) {
                com.baidu.tbadk.data.m mVar2 = (com.baidu.tbadk.data.m) mVar;
                if (mVar2.atE()) {
                    a(mVar2, list, i);
                } else {
                    b(mVar2, list, i);
                }
            }
        }
    }

    private void caW() {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.choose_local_photo), this.mPageContext.getString(R.string.change_system_photo)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.g.1
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    g.this.iqI = false;
                    switch (i) {
                        case 0:
                            g.this.cba();
                            break;
                        case 1:
                            g.this.cbb();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.showDialog();
        }
    }

    private void a(final com.baidu.tbadk.data.m mVar, final List<m> list, final int i) {
        if (this.mPageContext != null) {
            String[] strArr = {this.mPageContext.getString(R.string.hd_photo), this.mPageContext.getString(R.string.change_photo), this.mPageContext.getString(R.string.change_system_photo), this.mPageContext.getString(R.string.check_headpendant)};
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.g.2
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    g.this.iqI = true;
                    switch (i2) {
                        case 0:
                            g.this.c(mVar, list, i);
                            break;
                        case 1:
                            g.this.cba();
                            break;
                        case 2:
                            g.this.cbb();
                            break;
                        case 3:
                            TiebaStatic.log(new an("c11616").O("obj_type", 1));
                            g.this.cbc();
                            break;
                    }
                    if (iVar.isShowing()) {
                        iVar.dismiss();
                    }
                }
            });
            iVar.showDialog();
        }
    }

    private void b(final com.baidu.tbadk.data.m mVar, final List<m> list, final int i) {
        String[] strArr = {this.mPageContext.getString(R.string.look_big_photo), this.mPageContext.getString(R.string.set_as_portrait_photo), this.mPageContext.getString(R.string.delete)};
        final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mPageContext);
        iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.personPolymeric.b.g.3
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i2, View view) {
                switch (i2) {
                    case 0:
                        g.this.c(mVar, list, i);
                        break;
                    case 1:
                        h.a(mVar, g.this.mPageContext.getUniqueId());
                        break;
                    case 2:
                        h.a(mVar, list);
                        break;
                }
                if (iVar.isShowing()) {
                    iVar.dismiss();
                }
            }
        });
        iVar.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.data.m mVar, List<m> list, int i) {
        if (this.mPageContext != null && mVar != null && list != null && !StringUtils.isNull(mVar.atD())) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (m mVar2 : list) {
                if (mVar2 instanceof com.baidu.tbadk.data.m) {
                    com.baidu.tbadk.data.m mVar3 = (com.baidu.tbadk.data.m) mVar2;
                    if (mVar3.atE() && !mVar3.atD().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        arrayList.add(h.d(this.mPageContext, mVar3.atD()));
                    } else {
                        arrayList.add(mVar3.atD());
                    }
                }
            }
            int size = arrayList.size();
            String str = "";
            if (size > 0) {
                str = arrayList.get(size - 1);
            }
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, new ImageViewerConfig(this.mPageContext.getPageActivity()).createConfig(arrayList, i, null, "", "", true, str, true).setIsShowHost(false)));
        }
    }

    public void aw(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(this.mPageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f, this.iqI)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void caX() {
        if (this.iqJ != null && this.iqJ.getUserData() != null) {
            com.baidu.tbadk.imageManager.c.avs().deletePhoto(this.iqJ.getUserData().getPortrait());
        }
    }

    public void pB(boolean z) {
    }

    public void caY() {
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iqM, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PersonChangeData personChangeData) {
        if (personChangeData != null && this.iqJ != null && this.iqJ.getUserData() != null && this.iqJ.isHost() && personChangeData.getPhotoChanged()) {
            if (this.mPersonChangeData == null) {
                this.mPersonChangeData = new PersonChangeData();
            }
            this.mPersonChangeData.setPhotoChanged(true);
            caX();
        }
    }

    public void caZ() {
        new com.baidu.tieba.person.a().a(TbConfig.PERSON_USER_PIC_TEMP_FILE, new a.b() { // from class: com.baidu.tieba.personPolymeric.b.g.8
            @Override // com.baidu.tieba.person.a.b
            public void a(int i, String str, ImageUploadResult imageUploadResult) {
                if (i == 0 && imageUploadResult != null) {
                    String str2 = null;
                    if (imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null) {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    h.q(str2, g.this.caV());
                    g.this.pB(true);
                }
            }
        });
    }

    public void cba() {
        if (this.mPageContext != null) {
            Activity pageActivity = this.mPageContext.getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.mPageContext.getPageActivity(), this.writeImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
            }
        }
    }

    public void cbb() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(this.mPageContext.getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST, this.iqI)));
        }
    }

    public void cbc() {
        if (this.mPageContext != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AvatarPendantActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iqM);
    }
}
