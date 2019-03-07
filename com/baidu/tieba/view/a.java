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
    private List<C0311a> aMF;
    private LinearLayout bFA;
    private View bFB;
    private TextView bFC;
    private Context bFy;
    private TextView btX;
    private d jhl;
    private b jhm;
    private boolean jhn;
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
            this.bFy = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bFA = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.btX = (TextView) this.view.findViewById(d.g.title);
            this.bFB = this.view.findViewById(d.g.title_divide_line);
            this.aMF = new ArrayList();
            this.bFC = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFy;
    }

    public ViewGroup abi() {
        return this.bFA;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cmM() {
        return this.jhl;
    }

    public void P(List<C0311a> list) {
        if (list != null) {
            this.aMF = list;
            this.bFA.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0311a c0311a = list.get(i2);
                    if (c0311a != null) {
                        this.bFA.addView(c0311a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jhm = bVar;
    }

    public void onChangeSkinType() {
        al.k(this.btX, d.f.bg_title_corner_dialog_item);
        al.j(this.btX, d.C0236d.cp_cont_c);
        al.l(this.bFB, d.C0236d.cp_bg_line_c);
        al.k(this.bFC, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFC, d.C0236d.cp_cont_j);
        if (this.aMF != null) {
            for (C0311a c0311a : this.aMF) {
                c0311a.onChangeSkinType();
            }
        }
        if (this.jhn) {
            if (!StringUtils.isNull(this.titleText) && this.btX != null && (this.btX.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(d.e.tbds32);
                ((GradientDrawable) this.btX.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.S(this.aMF) > 0) {
                C0311a c0311a2 = this.aMF.get(0);
                if (!c0311a2.jhr) {
                    c0311a2.jhr = true;
                    c0311a2.onChangeSkinType();
                }
            }
        }
    }

    public View abk() {
        if (!StringUtils.isNull(this.titleText)) {
            this.btX.setText(this.titleText);
            this.bFB.setVisibility(0);
        } else {
            this.btX.setVisibility(8);
            this.bFB.setVisibility(8);
        }
        if (this.jhm != null) {
            this.bFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jhm.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0311a {
        private String alI;
        private View bFo;
        private int bFp;
        private int bFq;
        private boolean bFs;
        private a jhp;
        private c jhq;
        public boolean jhr;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0311a(a aVar) {
            this(null, aVar);
        }

        public C0311a(String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.bFp = d.f.person_more_pop_item_bg_selector;
            this.bFq = 17;
            this.bFs = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0311a.this.jhq != null) {
                        C0311a.this.jhq.onClick();
                    }
                    if (C0311a.this.jhp != null && C0311a.this.jhp.cmM() != null) {
                        C0311a.this.jhp.cmM().m(C0311a.this.mId, view);
                    }
                }
            };
            this.alI = str;
            this.jhp = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.alI = str;
            this.mTextView.setText(this.alI);
        }

        public void a(c cVar) {
            this.jhq = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.jhr) {
                al.k(this.mTextView, d.f.bg_bottom_up_corner_dialog);
            } else {
                al.k(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            }
            al.j(this.mTextView, d.C0236d.cp_cont_b);
            al.l(this.bFo, d.C0236d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jhp != null && this.jhp.getContext() != null) {
                this.mView = LayoutInflater.from(this.jhp.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jhp.abi(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alI);
                this.mTextView.setGravity(this.bFq);
                this.bFo = this.mView.findViewById(d.g.divider_line);
                if (this.bFs) {
                    this.bFo.setVisibility(0);
                } else {
                    this.bFo.setVisibility(8);
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
