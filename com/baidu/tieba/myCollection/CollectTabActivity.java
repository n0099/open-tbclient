package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    private a eTQ;
    private CustomMessageListener eTR = new CustomMessageListener(2022209) { // from class: com.baidu.tieba.myCollection.CollectTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Bundle) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                boolean z = bundle.getBoolean("is_enable_edit", true);
                int i = bundle.getInt("fragment_type", -1);
                if (i != -1 && i == CollectTabActivity.this.eTQ.aSz()) {
                    CollectTabActivity.this.eTQ.iQ(z);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.collect_tab_activity);
        this.eTQ = new a(this);
        registerListener(this.eTR);
        aSy();
        Q(getIntent());
    }

    protected void aSy() {
        com.baidu.tbadk.collectTab.a aVar = new com.baidu.tbadk.collectTab.a(getPageContext().getPageActivity());
        ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
        aVar.a(threadDelegateStatic);
        if (aVar.getContext() != null) {
            com.baidu.tbadk.mainTab.c Fw = threadDelegateStatic.Fw();
            if (Fw != null) {
                Fw.aIn.setArguments(new Bundle());
            } else {
                return;
            }
        }
        this.eTQ.ah(aVar.pw());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.eTQ.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.eTQ.aSB()) {
            this.eTQ.iP(!this.eTQ.aSC());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b.aSD().iR(true);
        b.aSD().iS(false);
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), 28);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b.aSD().iR(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment aSA = this.eTQ.aSA();
        if (aSA != null) {
            aSA.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
        }
        if (bundle != null) {
            bundle.remove("android:support:fragments");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Q(intent);
        setIntent(intent);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmycollection://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> ep = ax.ep(decode);
                if (ep != null) {
                    TiebaStatic.log(new al("c10320").ac("obj_locate", ep.get("obj_locate")).r("obj_type", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ep.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)).ac("obj_param2", ep.get("obj_param2")).r("obj_to", 4));
                }
            }
        }
    }
}
