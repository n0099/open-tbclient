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
    public View f19724a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f19725b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f19726c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f19727d;

    /* renamed from: e  reason: collision with root package name */
    public String f19728e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f19729f;

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
        this.f19729f = new a(2921471);
        this.f19724a = view;
        this.f19725b = (LinearLayout) view.findViewById(R.id.pb_more_view);
        this.f19726c = (TextView) view.findViewById(R.id.pb_more_text);
        this.f19727d = (ProgressBar) view.findViewById(R.id.progress);
        this.f19725b.setVisibility(0);
        this.f19729f.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f19729f);
        c();
    }

    public void b() {
        this.f19727d.setVisibility(8);
        String str = this.f19728e;
        if (str != null) {
            this.f19726c.setText(str);
        } else {
            this.f19726c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.pb_load_more));
        }
    }

    public void c() {
        this.f19726c.setTextColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), R.color.CAM_X0109));
        this.f19725b.setBackgroundResource(R.drawable.pb_foot_more_trans_selector);
    }

    public void d(View.OnClickListener onClickListener) {
        this.f19724a.setOnClickListener(onClickListener);
    }

    public void e(String str, int i) {
        this.f19728e = str;
        this.f19726c.setText(str);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19725b.getLayoutParams();
        layoutParams.height = i;
        layoutParams.bottomMargin = 0;
        this.f19725b.setLayoutParams(layoutParams);
    }

    public void f() {
        this.f19727d.setVisibility(0);
        this.f19726c.setText(TbadkCoreApplication.getInst().getContext().getText(R.string.loading));
    }
}
