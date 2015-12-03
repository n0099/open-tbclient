package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MemberBuyEntryButton extends LinearLayout {
    private TextView dJE;

    public MemberBuyEntryButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MemberBuyEntryButton(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(n.g.member_buy_entry_layout, (ViewGroup) this, true);
        this.dJE = (TextView) findViewById(n.f.buy_entry_button);
        this.dJE.setOnClickListener(new a(this, null));
        setVisibility(8);
    }

    public void show(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(MemberBuyEntryButton memberBuyEntryButton, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(MemberBuyEntryButton.this.getContext(), 2)));
        }
    }

    public void onChangeSkinType(h<?> hVar, int i) {
        as.i(this, n.c.cp_cont_g);
    }
}
