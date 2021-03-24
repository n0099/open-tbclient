package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19723a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19724b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19725c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f19726d;

    /* renamed from: e  reason: collision with root package name */
    public String f19727e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f19728f;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                PbLoadMoreItemViewHolder.this.f();
            } else {
                PbLoadMoreItemViewHolder.this.b();
            }
        }
    }

    public PbLoadMoreItemViewHolder(View view, BdUniqueId bdUniqueId) {
        super(view);
        this.f19728f = new a(2921471);
        this.f19723a = view;
        this.f19724b = (LinearLayout) view.findViewById(R.id.pb_more_view);
        this.f19725c = (TextView) view.findViewById(R.id.pb_more_text);
        this.f19726d = (ProgressBar) view.findViewById(R.id.progress);
        this.f19724b.setVisibility(0);
        this.f19728f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f19728f);
        c();
    }

    public void b() {
        this.f19726d.setVisibility(8);
        String str = this.f19727e;
        if (str != null) {
            this.f19725c.setText(str);
        } else {
            this.f19725c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.pb_load_more));
        }
    }

    public void c() {
        this.f19725c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0109));
        this.f19724b.setBackgroundResource(R.drawable.pb_foot_more_trans_selector);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f19723a.setOnClickListener(onClickListener);
    }

    public void e(String str, int i) {
        this.f19727e = str;
        this.f19725c.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19724b.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.f19724b.setLayoutParams(layoutParams);
    }

    public void f() {
        this.f19726d.setVisibility(0);
        this.f19725c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.loading));
    }
}
