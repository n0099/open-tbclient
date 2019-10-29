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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.officialNotification.OfficialNotificationListModel;
/* loaded from: classes4.dex */
public class OfficialNotificationFragment extends BaseFragment implements View.OnClickListener, NoNetworkView.a {
    private com.baidu.tieba.imMessageCenter.mention.officialNotification.b gWs;
    private OfficialNotificationListModel gWt;
    private TbPageContext mPageContext;
    private String mUid;
    private CustomMessageListener gAF = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(OfficialNotificationFragment.this.getPageContext().getPageActivity(), OfficialNotificationFragment.this.gWu, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    protected com.baidu.adp.base.d gAG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.3
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            if (OfficialNotificationFragment.this.gWt != null && OfficialNotificationFragment.this.gWs != null && !aq.isEmpty(OfficialNotificationFragment.this.mUid) && OfficialNotificationFragment.this.gWt.getUser() != null && aq.equals(OfficialNotificationFragment.this.mUid, OfficialNotificationFragment.this.gWt.getUser().getUserId())) {
                switch (OfficialNotificationFragment.this.gWt.getLoadDataMode()) {
                    case 1:
                        OfficialNotificationFragment.this.gWs.refreshGo2New(OfficialNotificationFragment.this.gWt.getData());
                        return;
                    case 2:
                        OfficialNotificationFragment.this.gWs.refreshPrepage(OfficialNotificationFragment.this.gWt.getData());
                        return;
                    case 3:
                        OfficialNotificationFragment.this.gWs.refreshCheckNew(OfficialNotificationFragment.this.gWt.getData());
                        return;
                    default:
                        return;
                }
            }
        }
    };
    com.baidu.tbadk.widget.richText.e gWu = new com.baidu.tbadk.widget.richText.e() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.4
        @Override // com.baidu.tbadk.widget.richText.e
        public ListView getListView() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public int azP() {
            return 0;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<ImageView> azQ() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<TextView> azR() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<GifView> azS() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<View> azT() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<LinearLayout> azU() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public com.baidu.adp.lib.e.b<RelativeLayout> azV() {
            return null;
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ai(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void d(Context context, String str, boolean z) {
            ba.amQ().b(OfficialNotificationFragment.this.getPageContext(), new String[]{str});
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void aj(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void ak(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void al(Context context, String str) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void o(Context context, String str, String str2) {
        }

        @Override // com.baidu.tbadk.widget.richText.e
        public void am(Context context, String str) {
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mPageContext = getPageContext();
        T(bundle);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.gWs = new com.baidu.tieba.imMessageCenter.mention.officialNotification.b(this.mPageContext, this, viewGroup);
        if (this.gWt != null) {
            this.gWs.a(this.gWt.getData());
            this.gWt.loadFirst(null);
        }
        return this.gWs.getView();
    }

    protected boolean T(Bundle bundle) {
        this.mUid = com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqV();
        this.gWt = new OfficialNotificationListModel(this.mPageContext);
        this.gWt.setLoadDataCallBack(this.gAG);
        if (bundle != null) {
            U(bundle);
            return true;
        }
        bxE();
        return true;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void onNetworkChange(boolean z) {
    }

    protected void U(Bundle bundle) {
        if (this.gWt != null) {
            this.gWt.setIsAcceptNotify(true);
            V(bundle);
        }
    }

    protected void bxE() {
        if (this.gWt != null) {
            this.gWt.setIsAcceptNotify(true);
            bFP();
        }
    }

    protected void V(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            this.gWt.setUser(userData);
        }
    }

    protected void bFP() {
        if (!aq.isEmpty(this.mUid) && this.mPageContext != null && this.gWt != null) {
            UserData userData = new UserData(Long.parseLong(this.mUid), this.mPageContext.getString(R.string.system_message), null, 0);
            b(userData);
            this.gWt.setUser(userData);
        }
    }

    protected void b(final UserData userData) {
        z.b(new y<Void>() { // from class: com.baidu.tieba.imMessageCenter.mention.OfficialNotificationFragment.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.y
            /* renamed from: aEg */
            public Void doInBackground() {
                com.baidu.tieba.im.settingcache.d.bEf().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(1), userData);
                return null;
            }
        }, null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        registerListener(this.gAF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().unRegisterListener(this.gAF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.gWt.onDestroy();
        this.gWt.setLoadDataCallBack(null);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if ((id == R.id.iv_head || id == R.id.tv_user_name) && !aq.isEmpty(this.mUid)) {
            TiebaStatic.log("c12938");
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecommendDetailActivityConfig(getPageContext().getPageActivity(), null, Long.parseLong(this.mUid))));
        }
    }

    public void aLG() {
        if (this.gWt != null) {
            this.gWt.loadPrepage();
        }
    }

    public boolean getHasMore() {
        if (this.gWt == null || this.gWt.getData() == null) {
            return true;
        }
        return this.gWt.getData().getIsNewAdd();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gWs != null) {
            this.gWs.onChangeSkinType();
        }
    }
}
