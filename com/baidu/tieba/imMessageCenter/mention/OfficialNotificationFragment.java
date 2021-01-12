package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes2.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b kJT;
    private OfficialNotificationListModel kJU;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener joX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.kJV, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.e kth = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.kJU != null && OfficialNotificationFragment.this.kJT != null && !at.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.kJU.getUser() != null && at.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.kJU.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.kJU.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.kJT.refreshGo2New(OfficialNotificationFragment.this.kJU.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.kJT.refreshPrepage(OfficialNotificationFragment.this.kJU.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.kJT.refreshCheckNew(OfficialNotificationFragment.this.kJU.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.h kJV = new com.baidu.tbadk.widget.richText.h() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.h
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public int bHN() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<ImageView> bHO() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<TextView> bHP() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<GifView> bHQ() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<View> bHR() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<LinearLayout> bHS() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public com.baidu.adp.lib.d.b<RelativeLayout> bHT() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aF(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void g(Context context, String str, boolean z) {
            be.bsB().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aG(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aH(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aI(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void u(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.h
        public void aJ(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        au(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.kJT = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.kJU != null) {
            this.kJT.a(this.kJU.getData());
            this.kJU.loadFirst(null);
        }
        return this.kJT.getView();
    }

    protected boolean au(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxH();
        this.kJU = new OfficialNotificationListModel(this.mPageContext);
        this.kJU.setLoadDataCallBack(this.kth);
        if (bundle != null) {
            av(bundle);
            return true;
        }
        cSu();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void av(Bundle bundle) {
        if (this.kJU != null) {
            this.kJU.setIsAcceptNotify(true);
            aw(bundle);
        }
    }

    protected void cSu() {
        if (this.kJU != null) {
            this.kJU.setIsAcceptNotify(true);
            cXv();
        }
    }

    protected void aw(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.kJU.setUser(userData);
        }
    }

    protected void cXv() {
        if (!at.isEmpty(this.mUid) && this.mPageContext != null && this.kJU != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.kJU.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ac.b(new ab<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bLv */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cVV().b(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.joX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.joX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.kJU.onDestroy();
        this.kJU.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !at.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void bVe() {
        if (this.kJU != null) {
            this.kJU.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.kJU == null || this.kJU.getData() == null) {
            return true;
        }
        return this.kJU.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kJT != null) {
            this.kJT.onChangeSkinType();
        }
    }
}
