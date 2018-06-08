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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.d;
import java.util.Map;
/* loaded from: classes3.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    private a ffi;
    private CustomMessageListener ffj = new CustomMessageListener(2022209) { // from class: com.baidu.tieba.myCollection.CollectTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Bundle) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                boolean z = bundle.getBoolean("is_enable_edit", true);
                int i = bundle.getInt("fragment_type", -1);
                if (i != -1 && i == CollectTabActivity.this.ffi.aXv()) {
                    CollectTabActivity.this.ffi.iW(z);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.collect_tab_activity);
        this.ffi = new a(this);
        registerListener(this.ffj);
        aXu();
        Q(getIntent());
    }

    protected void aXu() {
        com.baidu.tbadk.collectTab.a aVar = new com.baidu.tbadk.collectTab.a(getPageContext().getPageActivity());
        ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
        aVar.a(threadDelegateStatic);
        if (aVar.getContext() != null) {
            com.baidu.tbadk.mainTab.c Jb = threadDelegateStatic.Jb();
            if (Jb != null) {
                Jb.aQP.setArguments(new Bundle());
            } else {
                return;
            }
        }
        this.ffi.ah(aVar.sR());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.ffi.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ffi.aXx()) {
            this.ffi.iV(!this.ffi.aXy());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        b.aXz().iX(true);
        b.aXz().iY(false);
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), 28);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b.aXz().iX(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment aXw = this.ffi.aXw();
        if (aXw != null) {
            aXw.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
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
                Map<String, String> eO = ay.eO(decode);
                if (eO != null) {
                    TiebaStatic.log(new am("c10320").ah("obj_locate", eO.get("obj_locate")).r("obj_type", 1).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eO.get(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)).ah("obj_param2", eO.get("obj_param2")).r("obj_to", 4));
                }
            }
        }
    }
}
