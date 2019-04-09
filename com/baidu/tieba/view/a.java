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
    private List<C0407a> aMK;
    private Context bFD;
    private LinearLayout bFF;
    private View bFG;
    private TextView bFH;
    private TextView bud;
    private d jhm;
    private b jhn;
    private boolean jho;
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
            this.bFD = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bFF = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.bud = (TextView) this.view.findViewById(d.g.title);
            this.bFG = this.view.findViewById(d.g.title_divide_line);
            this.aMK = new ArrayList();
            this.bFH = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFD;
    }

    public ViewGroup abf() {
        return this.bFF;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cmX() {
        return this.jhm;
    }

    public void P(List<C0407a> list) {
        if (list != null) {
            this.aMK = list;
            this.bFF.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0407a c0407a = list.get(i2);
                    if (c0407a != null) {
                        this.bFF.addView(c0407a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jhn = bVar;
    }

    public void onChangeSkinType() {
        al.k(this.bud, d.f.bg_title_corner_dialog_item);
        al.j(this.bud, d.C0277d.cp_cont_c);
        al.l(this.bFG, d.C0277d.cp_bg_line_c);
        al.k(this.bFH, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFH, d.C0277d.cp_cont_j);
        if (this.aMK != null) {
            for (C0407a c0407a : this.aMK) {
                c0407a.onChangeSkinType();
            }
        }
        if (this.jho) {
            if (!StringUtils.isNull(this.titleText) && this.bud != null && (this.bud.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(d.e.tbds32);
                ((GradientDrawable) this.bud.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.S(this.aMK) > 0) {
                C0407a c0407a2 = this.aMK.get(0);
                if (!c0407a2.jhs) {
                    c0407a2.jhs = true;
                    c0407a2.onChangeSkinType();
                }
            }
        }
    }

    public View abh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bud.setText(this.titleText);
            this.bFG.setVisibility(0);
        } else {
            this.bud.setVisibility(8);
            this.bFG.setVisibility(8);
        }
        if (this.jhn != null) {
            this.bFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jhn.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0407a {
        private String alO;
        private View bFt;
        private int bFu;
        private int bFv;
        private boolean bFx;
        private a jhq;
        private c jhr;
        public boolean jhs;
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
            this.bFu = d.f.person_more_pop_item_bg_selector;
            this.bFv = 17;
            this.bFx = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0407a.this.jhr != null) {
                        C0407a.this.jhr.onClick();
                    }
                    if (C0407a.this.jhq != null && C0407a.this.jhq.cmX() != null) {
                        C0407a.this.jhq.cmX().m(C0407a.this.mId, view);
                    }
                }
            };
            this.alO = str;
            this.jhq = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.alO = str;
            this.mTextView.setText(this.alO);
        }

        public void a(c cVar) {
            this.jhr = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.jhs) {
                al.k(this.mTextView, d.f.bg_bottom_up_corner_dialog);
            } else {
                al.k(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            }
            al.j(this.mTextView, d.C0277d.cp_cont_b);
            al.l(this.bFt, d.C0277d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jhq != null && this.jhq.getContext() != null) {
                this.mView = LayoutInflater.from(this.jhq.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jhq.abf(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alO);
                this.mTextView.setGravity(this.bFv);
                this.bFt = this.mView.findViewById(d.g.divider_line);
                if (this.bFx) {
                    this.bFt.setVisibility(0);
                } else {
                    this.bFt.setVisibility(8);
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
