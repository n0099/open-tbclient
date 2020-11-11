package com.baidu.tieba.imMessageCenter.mention;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes22.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b kvj;
    private OfficialNotificationListModel kvk;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener jWO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.kvl, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d jWP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.kvk != null && OfficialNotificationFragment.this.kvj != null && !at.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.kvk.getUser() != null && at.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.kvk.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.kvk.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.kvj.refreshGo2New(OfficialNotificationFragment.this.kvk.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.kvj.refreshPrepage(OfficialNotificationFragment.this.kvk.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.kvj.refreshCheckNew(OfficialNotificationFragment.this.kvk.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.i kvl = new com.baidu.tbadk.widget.richText.i() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.i
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public int bGt() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<ImageView> bGu() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<TextView> bGv() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<GifView> bGw() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<View> bGx() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<LinearLayout> bGy() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public com.baidu.adp.lib.d.b<RelativeLayout> bGz() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void ax(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void f(Context context, String str, boolean z) {
            be.brr().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void ay(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void az(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void aA(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void u(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.i
        public void aB(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        at(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.kvj = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.kvk != null) {
            this.kvj.a(this.kvk.getData());
            this.kvk.loadFirst(null);
        }
        return this.kvj.getView();
    }

    protected boolean at(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.bvS().bwq();
        this.kvk = new OfficialNotificationListModel(this.mPageContext);
        this.kvk.setLoadDataCallBack(this.jWP);
        if (bundle != null) {
            au(bundle);
            return true;
        }
        cOk();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void au(Bundle bundle) {
        if (this.kvk != null) {
            this.kvk.setIsAcceptNotify(true);
            av(bundle);
        }
    }

    protected void cOk() {
        if (this.kvk != null) {
            this.kvk.setIsAcceptNotify(true);
            cWQ();
        }
    }

    protected void av(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.kvk.setUser(userData);
        }
    }

    protected void cWQ() {
        if (!at.isEmpty(this.mUid) && this.mPageContext != null && this.kvk != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.kvk.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        ae.b(new ad<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bJS */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.cVg().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.jWO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.jWO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.kvk.onDestroy();
        this.kvk.setLoadDataCallBack(null);
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

    public void bTm() {
        if (this.kvk != null) {
            this.kvk.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.kvk == null || this.kvk.getData() == null) {
            return true;
        }
        return this.kvk.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kvj != null) {
            this.kvj.onChangeSkinType();
        }
    }
}
