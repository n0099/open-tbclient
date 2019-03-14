package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<C0407a> aMG;
    private Context bFA;
    private LinearLayout bFC;
    private View bFD;
    private TextView bFE;
    private TextView btZ;
    private d jhx;
    private b jhy;
    private boolean jhz;
    private String titleText;
    private View view;

    /* loaded from: classes.dex */
    public interface b {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface c {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface d {
        void m(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.bFA = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bFC = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.btZ = (TextView) this.view.findViewById(d.g.title);
            this.bFD = this.view.findViewById(d.g.title_divide_line);
            this.aMG = new ArrayList();
            this.bFE = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFA;
    }

    public ViewGroup abi() {
        return this.bFC;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cmZ() {
        return this.jhx;
    }

    public void P(List<C0407a> list) {
        if (list != null) {
            this.aMG = list;
            this.bFC.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0407a c0407a = list.get(i2);
                    if (c0407a != null) {
                        this.bFC.addView(c0407a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jhy = bVar;
    }

    public void onChangeSkinType() {
        al.k(this.btZ, d.f.bg_title_corner_dialog_item);
        al.j(this.btZ, d.C0277d.cp_cont_c);
        al.l(this.bFD, d.C0277d.cp_bg_line_c);
        al.k(this.bFE, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFE, d.C0277d.cp_cont_j);
        if (this.aMG != null) {
            for (C0407a c0407a : this.aMG) {
                c0407a.onChangeSkinType();
            }
        }
        if (this.jhz) {
            if (!StringUtils.isNull(this.titleText) && this.btZ != null && (this.btZ.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(d.e.tbds32);
                ((GradientDrawable) this.btZ.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.S(this.aMG) > 0) {
                C0407a c0407a2 = this.aMG.get(0);
                if (!c0407a2.jhD) {
                    c0407a2.jhD = true;
                    c0407a2.onChangeSkinType();
                }
            }
        }
    }

    public View abk() {
        if (!StringUtils.isNull(this.titleText)) {
            this.btZ.setText(this.titleText);
            this.bFD.setVisibility(0);
        } else {
            this.btZ.setVisibility(8);
            this.bFD.setVisibility(8);
        }
        if (this.jhy != null) {
            this.bFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jhy.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0407a {
        private String alJ;
        private View bFq;
        private int bFr;
        private int bFs;
        private boolean bFu;
        private a jhB;
        private c jhC;
        public boolean jhD;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0407a(a aVar) {
            this(null, aVar);
        }

        public C0407a(String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.bFr = d.f.person_more_pop_item_bg_selector;
            this.bFs = 17;
            this.bFu = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0407a.this.jhC != null) {
                        C0407a.this.jhC.onClick();
                    }
                    if (C0407a.this.jhB != null && C0407a.this.jhB.cmZ() != null) {
                        C0407a.this.jhB.cmZ().m(C0407a.this.mId, view);
                    }
                }
            };
            this.alJ = str;
            this.jhB = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.alJ = str;
            this.mTextView.setText(this.alJ);
        }

        public void a(c cVar) {
            this.jhC = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.jhD) {
                al.k(this.mTextView, d.f.bg_bottom_up_corner_dialog);
            } else {
                al.k(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            }
            al.j(this.mTextView, d.C0277d.cp_cont_b);
            al.l(this.bFq, d.C0277d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jhB != null && this.jhB.getContext() != null) {
                this.mView = LayoutInflater.from(this.jhB.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jhB.abi(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alJ);
                this.mTextView.setGravity(this.bFs);
                this.bFq = this.mView.findViewById(d.g.divider_line);
                if (this.bFu) {
                    this.bFq.setVisibility(0);
                } else {
                    this.bFq.setVisibility(8);
                }
                onChangeSkinType();
            }
        }

        private void initListener() {
            if (this.mTextView != null) {
                this.mTextView.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
