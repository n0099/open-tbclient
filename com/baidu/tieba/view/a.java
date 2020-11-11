package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private Context eIE;
    private LinearLayout eIG;
    private View eIH;
    private TextView eII;
    private TextView evg;
    private List<C0870a> mItems;
    private d nyG;
    private b nyH;
    private boolean nyI;
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
        void k(int i, View view);
    }

    public a(Context context) {
        if (context != null) {
            this.eIE = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.eIG = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.evg = (TextView) this.view.findViewById(R.id.title);
            this.eIH = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.eII = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.eIE;
    }

    public ViewGroup getView() {
        return this.eIG;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d dSx() {
        return this.nyG;
    }

    public void br(List<C0870a> list) {
        if (list != null) {
            this.mItems = list;
            this.eIG.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0870a c0870a = list.get(i2);
                    if (c0870a != null) {
                        this.eIG.addView(c0870a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.nyH = bVar;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.evg, R.drawable.bg_title_corner_dialog_item);
        ap.setViewTextColor(this.evg, R.color.cp_cont_c);
        ap.setBackgroundColor(this.eIH, R.color.cp_bg_line_c);
        ap.setBackgroundResource(this.eII, R.drawable.bg_bottom_up_list_dialog_item);
        ap.setViewTextColor(this.eII, R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0870a c0870a : this.mItems) {
                c0870a.onChangeSkinType();
            }
        }
        if (this.nyI) {
            if (!StringUtils.isNull(this.titleText) && this.evg != null && (this.evg.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.evg.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (y.getCount(this.mItems) > 0) {
                C0870a c0870a2 = this.mItems.get(0);
                if (!c0870a2.nyM) {
                    c0870a2.nyM = true;
                    c0870a2.onChangeSkinType();
                }
            }
        }
    }

    public View bps() {
        if (!StringUtils.isNull(this.titleText)) {
            this.evg.setText(this.titleText);
            this.eIH.setVisibility(0);
        } else {
            this.evg.setVisibility(8);
            this.eIH.setVisibility(8);
        }
        if (this.nyH != null) {
            this.eII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.nyH.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0870a {
        private View eIp;
        private int eIq;
        private int eIr;
        private boolean eIt;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;
        private a nyK;
        private c nyL;
        public boolean nyM;

        public C0870a(a aVar) {
            this(null, aVar);
        }

        public C0870a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.eIq = R.drawable.person_more_pop_item_bg_selector;
            this.eIr = 17;
            this.eIt = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0870a.this.nyL != null) {
                        C0870a.this.nyL.onClick();
                    }
                    if (C0870a.this.nyK != null && C0870a.this.nyK.dSx() != null) {
                        C0870a.this.nyK.dSx().k(C0870a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.nyK = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.mText = str;
            this.mTextView.setText(this.mText);
        }

        public void a(c cVar) {
            this.nyL = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.nyM) {
                    ap.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(ap.oX(R.color.cp_bg_line_k));
                }
            }
            ap.setViewTextColor(this.mTextView, R.color.cp_cont_b);
            ap.setBackgroundColor(this.eIp, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.nyK != null && this.nyK.getContext() != null) {
                this.mView = LayoutInflater.from(this.nyK.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.nyK.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.eIr);
                this.eIp = this.mView.findViewById(R.id.divider_line);
                if (this.eIt) {
                    this.eIp.setVisibility(0);
                } else {
                    this.eIp.setVisibility(8);
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
