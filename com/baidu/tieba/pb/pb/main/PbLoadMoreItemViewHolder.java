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
/* loaded from: classes3.dex */
public class PbLoadMoreItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public View f19417a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19418b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19419c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f19420d;

    /* renamed from: e  reason: collision with root package name */
    public String f19421e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f19422f;

    /* loaded from: classes3.dex */
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
        this.f19422f = new a(2921471);
        this.f19417a = view;
        this.f19418b = (LinearLayout) view.findViewById(R.id.pb_more_view);
        this.f19419c = (TextView) view.findViewById(R.id.pb_more_text);
        this.f19420d = (ProgressBar) view.findViewById(R.id.progress);
        this.f19418b.setVisibility(0);
        this.f19422f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f19422f);
        c();
    }

    public void b() {
        this.f19420d.setVisibility(8);
        String str = this.f19421e;
        if (str != null) {
            this.f19419c.setText(str);
        } else {
            this.f19419c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.pb_load_more));
        }
    }

    public void c() {
        this.f19419c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0109));
        this.f19418b.setBackgroundResource(R.drawable.pb_foot_more_trans_selector);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f19417a.setOnClickListener(onClickListener);
    }

    public void e(String str, int i) {
        this.f19421e = str;
        this.f19419c.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19418b.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.f19418b.setLayoutParams(layoutParams);
    }

    public void f() {
        this.f19420d.setVisibility(0);
        this.f19419c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.loading));
    }
}
