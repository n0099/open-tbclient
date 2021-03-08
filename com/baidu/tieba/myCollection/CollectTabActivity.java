package com.baidu.tieba.myCollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes7.dex */
public class CollectTabActivity extends BaseFragmentActivity {
    private a lyE;
    private CustomMessageListener lyF = new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_NAVI_EDIT_ENABLE) { // from class: com.baidu.tieba.myCollection.CollectTabActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof Bundle) {
                Bundle bundle = (Bundle) customResponsedMessage.getData();
                boolean z = bundle.getBoolean("is_enable_edit", true);
                int i = bundle.getInt("fragment_type", -1);
                if (i != -1 && i == CollectTabActivity.this.lyE.dhB()) {
                    CollectTabActivity.this.lyE.ud(z);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_tab_activity);
        this.lyE = new a(this);
        registerListener(this.lyF);
        dhA();
        aa(getIntent());
    }

    protected void dhA() {
        com.baidu.tbadk.collectTab.a aVar = new com.baidu.tbadk.collectTab.a(getPageContext().getPageActivity());
        ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
        aVar.a(threadDelegateStatic);
        if (aVar.getContext() != null) {
            com.baidu.tbadk.mainTab.c fragmentTabStructure = threadDelegateStatic.getFragmentTabStructure();
            if (fragmentTabStructure != null) {
                fragmentTabStructure.frag.setArguments(new Bundle());
            } else {
                return;
            }
        }
        this.lyE.aR(aVar.getList());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        super.changeSkinType(i);
        this.lyE.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lyE.dhD()) {
            boolean z = !this.lyE.dhE();
            if (z) {
                c.OR("c14067");
            }
            this.lyE.uc(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        c.OR("c14061");
        b.dhF().ue(true);
        b.dhF().uf(false);
        NotificationHelper.cancelNotification(getPageContext().getPageActivity(), 28);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        b.dhF().ue(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment dhC = this.lyE.dhC();
        if (dhC != null) {
            dhC.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        aa(intent);
        setIntent(intent);
    }

    private void aa(Intent intent) {
        if (intent != null) {
            String dataString = intent.getDataString();
            if (!StringUtils.isNull(dataString) && dataString.startsWith("tbmycollection://")) {
                String decode = Uri.decode(intent.getData().getEncodedPath());
                if (decode.startsWith("//")) {
                    decode = decode.substring(2);
                }
                Map<String, String> paramPair = bf.getParamPair(decode);
                if (paramPair != null) {
                    TiebaStatic.log(new ar("c10320").dR("obj_locate", paramPair.get("obj_locate")).aq("obj_type", 1).dR("obj_source", paramPair.get("obj_source")).dR(TiebaInitialize.Params.OBJ_PARAM2, paramPair.get(TiebaInitialize.Params.OBJ_PARAM2)).aq(TiebaInitialize.Params.OBJ_TO, 4).aq("obj_name", TbadkCoreApplication.getInst().getStartType()).aq(TiebaInitialize.Params.OBJ_PARAM3, 1));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a081";
    }
}
