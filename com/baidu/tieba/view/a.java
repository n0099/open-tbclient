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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<C0426a> aOH;
    private TextView bBh;
    private Context bNd;
    private LinearLayout bNf;
    private View bNg;
    private TextView bNh;
    private d jAh;
    private b jAi;
    private boolean jAj;
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
            this.bNd = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.bNf = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bBh = (TextView) this.view.findViewById(R.id.title);
            this.bNg = this.view.findViewById(R.id.title_divide_line);
            this.aOH = new ArrayList();
            this.bNh = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.bNd;
    }

    public ViewGroup afX() {
        return this.bNf;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cvc() {
        return this.jAh;
    }

    public void W(List<C0426a> list) {
        if (list != null) {
            this.aOH = list;
            this.bNf.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0426a c0426a = list.get(i2);
                    if (c0426a != null) {
                        this.bNf.addView(c0426a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jAi = bVar;
    }

    public void onChangeSkinType() {
        al.k(this.bBh, R.drawable.bg_title_corner_dialog_item);
        al.j(this.bBh, R.color.cp_cont_c);
        al.l(this.bNg, R.color.cp_bg_line_c);
        al.k(this.bNh, R.drawable.bg_bottom_up_list_dialog_item);
        al.j(this.bNh, R.color.cp_cont_j);
        if (this.aOH != null) {
            for (C0426a c0426a : this.aOH) {
                c0426a.onChangeSkinType();
            }
        }
        if (this.jAj) {
            if (!StringUtils.isNull(this.titleText) && this.bBh != null && (this.bBh.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.bBh.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.Z(this.aOH) > 0) {
                C0426a c0426a2 = this.aOH.get(0);
                if (!c0426a2.jAn) {
                    c0426a2.jAn = true;
                    c0426a2.onChangeSkinType();
                }
            }
        }
    }

    public View afZ() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bBh.setText(this.titleText);
            this.bNg.setVisibility(0);
        } else {
            this.bBh.setVisibility(8);
            this.bNg.setVisibility(8);
        }
        if (this.jAi != null) {
            this.bNh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jAi.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0426a {
        private String ama;
        private View bMQ;
        private int bMR;
        private int bMS;
        private boolean bMU;
        private a jAl;
        private c jAm;
        public boolean jAn;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0426a(a aVar) {
            this(null, aVar);
        }

        public C0426a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.bMR = R.drawable.person_more_pop_item_bg_selector;
            this.bMS = 17;
            this.bMU = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0426a.this.jAm != null) {
                        C0426a.this.jAm.onClick();
                    }
                    if (C0426a.this.jAl != null && C0426a.this.jAl.cvc() != null) {
                        C0426a.this.jAl.cvc().m(C0426a.this.mId, view);
                    }
                }
            };
            this.ama = str;
            this.jAl = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.ama = str;
            this.mTextView.setText(this.ama);
        }

        public void a(c cVar) {
            this.jAm = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.jAn) {
                al.k(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
            } else {
                al.k(this.mTextView, R.drawable.bg_bottom_up_list_dialog_item);
            }
            al.j(this.mTextView, R.color.cp_cont_b);
            al.l(this.bMQ, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jAl != null && this.jAl.getContext() != null) {
                this.mView = LayoutInflater.from(this.jAl.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jAl.afX(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.ama);
                this.mTextView.setGravity(this.bMS);
                this.bMQ = this.mView.findViewById(R.id.divider_line);
                if (this.bMU) {
                    this.bMQ.setVisibility(0);
                } else {
                    this.bMQ.setVisibility(8);
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
