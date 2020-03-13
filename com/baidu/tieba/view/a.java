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
    private TextView cKS;
    private Context cVK;
    private LinearLayout cVM;
    private View cVN;
    private TextView cVO;
    private d kHR;
    private b kHS;
    private boolean kHT;
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
            this.cVK = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.cVM = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.cKS = (TextView) this.view.findViewById(R.id.title);
            this.cVN = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cVO = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.cVK;
    }

    public ViewGroup getView() {
        return this.cVM;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cTu() {
        return this.kHR;
    }

    public void az(List<C0629a> list) {
        if (list != null) {
            this.mItems = list;
            this.cVM.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0629a c0629a = list.get(i2);
                    if (c0629a != null) {
                        this.cVM.addView(c0629a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.kHS = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cKS, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.cKS, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cVN, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cVO, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cVO, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0629a c0629a : this.mItems) {
                c0629a.onChangeSkinType();
            }
        }
        if (this.kHT) {
            if (!StringUtils.isNull(this.titleText) && this.cKS != null && (this.cKS.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.cKS.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0629a c0629a2 = this.mItems.get(0);
                if (!c0629a2.kHX) {
                    c0629a2.kHX = true;
                    c0629a2.onChangeSkinType();
                }
            }
        }
    }

    public View aER() {
        if (!StringUtils.isNull(this.titleText)) {
            this.cKS.setText(this.titleText);
            this.cVN.setVisibility(0);
        } else {
            this.cKS.setVisibility(8);
            this.cVN.setVisibility(8);
        }
        if (this.kHS != null) {
            this.cVO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kHS.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0629a {
        private View cVv;
        private int cVw;
        private int cVx;
        private boolean cVz;
        private a kHV;
        private c kHW;
        public boolean kHX;
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
            this.cVw = R.drawable.person_more_pop_item_bg_selector;
            this.cVx = 17;
            this.cVz = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0629a.this.kHW != null) {
                        C0629a.this.kHW.onClick();
                    }
                    if (C0629a.this.kHV != null && C0629a.this.kHV.cTu() != null) {
                        C0629a.this.kHV.cTu().k(C0629a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.kHV = aVar;
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
            this.kHW = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.kHX) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.kv(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.cVv, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.kHV != null && this.kHV.getContext() != null) {
                this.mView = LayoutInflater.from(this.kHV.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.kHV.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.cVx);
                this.cVv = this.mView.findViewById(R.id.divider_line);
                if (this.cVz) {
                    this.cVv.setVisibility(0);
                } else {
                    this.cVv.setVisibility(8);
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
