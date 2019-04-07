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
    private List<C0407a> aMJ;
    private Context bFC;
    private LinearLayout bFE;
    private View bFF;
    private TextView bFG;
    private TextView buc;
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
            this.bFC = context;
            this.view = LayoutInflater.from(context).inflate(d.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bFE = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.buc = (TextView) this.view.findViewById(d.g.title);
            this.bFF = this.view.findViewById(d.g.title_divide_line);
            this.aMJ = new ArrayList();
            this.bFG = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bFC;
    }

    public ViewGroup abf() {
        return this.bFE;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cmX() {
        return this.jhl;
    }

    public void P(List<C0407a> list) {
        if (list != null) {
            this.aMJ = list;
            this.bFE.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0407a c0407a = list.get(i2);
                    if (c0407a != null) {
                        this.bFE.addView(c0407a.getView());
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
        al.k(this.buc, d.f.bg_title_corner_dialog_item);
        al.j(this.buc, d.C0277d.cp_cont_c);
        al.l(this.bFF, d.C0277d.cp_bg_line_c);
        al.k(this.bFG, d.f.bg_bottom_up_list_dialog_item);
        al.j(this.bFG, d.C0277d.cp_cont_j);
        if (this.aMJ != null) {
            for (C0407a c0407a : this.aMJ) {
                c0407a.onChangeSkinType();
            }
        }
        if (this.jhn) {
            if (!StringUtils.isNull(this.titleText) && this.buc != null && (this.buc.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(d.e.tbds32);
                ((GradientDrawable) this.buc.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.S(this.aMJ) > 0) {
                C0407a c0407a2 = this.aMJ.get(0);
                if (!c0407a2.jhr) {
                    c0407a2.jhr = true;
                    c0407a2.onChangeSkinType();
                }
            }
        }
    }

    public View abh() {
        if (!StringUtils.isNull(this.titleText)) {
            this.buc.setText(this.titleText);
            this.bFF.setVisibility(0);
        } else {
            this.buc.setVisibility(8);
            this.bFF.setVisibility(8);
        }
        if (this.jhm != null) {
            this.bFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
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
    public static class C0407a {
        private String alN;
        private View bFs;
        private int bFt;
        private int bFu;
        private boolean bFw;
        private a jhp;
        private c jhq;
        public boolean jhr;
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
            this.bFt = d.f.person_more_pop_item_bg_selector;
            this.bFu = 17;
            this.bFw = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0407a.this.jhq != null) {
                        C0407a.this.jhq.onClick();
                    }
                    if (C0407a.this.jhp != null && C0407a.this.jhp.cmX() != null) {
                        C0407a.this.jhp.cmX().m(C0407a.this.mId, view);
                    }
                }
            };
            this.alN = str;
            this.jhp = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.alN = str;
            this.mTextView.setText(this.alN);
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
            al.j(this.mTextView, d.C0277d.cp_cont_b);
            al.l(this.bFs, d.C0277d.cp_bg_line_c);
        }

        private void initView() {
            if (this.jhp != null && this.jhp.getContext() != null) {
                this.mView = LayoutInflater.from(this.jhp.getContext()).inflate(d.h.bottom_up_list_dialog_item, this.jhp.abf(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.alN);
                this.mTextView.setGravity(this.bFu);
                this.bFs = this.mView.findViewById(d.g.divider_line);
                if (this.bFw) {
                    this.bFs.setVisibility(0);
                } else {
                    this.bFs.setVisibility(8);
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
