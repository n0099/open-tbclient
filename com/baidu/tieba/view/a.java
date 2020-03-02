package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView cKR;
    private Context cVJ;
    private LinearLayout cVL;
    private View cVM;
    private TextView cVN;
    private d kHF;
    private b kHG;
    private boolean kHH;
    private List<C0629a> mItems;
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
            this.cVJ = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.cVL = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cKR = (TextView) this.view.findViewById(R.id.title);
            this.cVM = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cVN = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVJ;
    }

    public ViewGroup getView() {
        return this.cVL;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cTt() {
        return this.kHF;
    }

    public void az(List<C0629a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVL.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0629a c0629a = list.get(i2);
                    if (c0629a != null) {
                        this.cVL.addView(c0629a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kHG = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cKR, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.cKR, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cVM, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVN, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cVN, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0629a c0629a : this.mItems) {
                c0629a.onChangeSkinType();
            }
        }
        if (this.kHH) {
            if (!StringUtils.isNull(this.titleText) && this.cKR != null && (this.cKR.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.cKR.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0629a c0629a2 = this.mItems.get(0);
                if (!c0629a2.kHL) {
                    c0629a2.kHL = true;
                    c0629a2.onChangeSkinType();
                }
            }
        }
    }

    public View aER() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKR.setText(this.titleText);
            this.cVM.setVisibility(0);
        } else {
            this.cKR.setVisibility(8);
            this.cVM.setVisibility(8);
        }
        if (this.kHG != null) {
            this.cVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kHG.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0629a {
        private View cVu;
        private int cVv;
        private int cVw;
        private boolean cVy;
        private a kHJ;
        private c kHK;
        public boolean kHL;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0629a(a aVar) {
            this(null, aVar);
        }

        public C0629a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.cVv = R.drawable.person_more_pop_item_bg_selector;
            this.cVw = 17;
            this.cVy = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0629a.this.kHK != null) {
                        C0629a.this.kHK.onClick();
                    }
                    if (C0629a.this.kHJ != null && C0629a.this.kHJ.cTt() != null) {
                        C0629a.this.kHJ.cTt().k(C0629a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.kHJ = aVar;
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
            this.kHK = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.kHL) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.kv(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.cVu, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kHJ != null && this.kHJ.getContext() != null) {
                this.mView = LayoutInflater.from(this.kHJ.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kHJ.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVw);
                this.cVu = this.mView.findViewById(R.id.divider_line);
                if (this.cVy) {
                    this.cVu.setVisibility(0);
                } else {
                    this.cVu.setVisibility(8);
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
