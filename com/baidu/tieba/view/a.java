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
    private TextView dkk;
    private Context dvi;
    private LinearLayout dvk;
    private View dvl;
    private TextView dvm;
    private d ltH;
    private b ltI;
    private boolean ltJ;
    private List<C0671a> mItems;
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
            this.dvi = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.dvk = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.dkk = (TextView) this.view.findViewById(R.id.title);
            this.dvl = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.dvm = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.dvi;
    }

    public ViewGroup getView() {
        return this.dvk;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d deC() {
        return this.ltH;
    }

    public void aI(List<C0671a> list) {
        if (list != null) {
            this.mItems = list;
            this.dvk.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0671a c0671a = list.get(i2);
                    if (c0671a != null) {
                        this.dvk.addView(c0671a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.ltI = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dkk, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.dkk, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.dvl, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.dvm, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.dvm, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0671a c0671a : this.mItems) {
                c0671a.onChangeSkinType();
            }
        }
        if (this.ltJ) {
            if (!StringUtils.isNull(this.titleText) && this.dkk != null && (this.dkk.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.dkk.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0671a c0671a2 = this.mItems.get(0);
                if (!c0671a2.ltN) {
                    c0671a2.ltN = true;
                    c0671a2.onChangeSkinType();
                }
            }
        }
    }

    public View aNj() {
        if (!StringUtils.isNull(this.titleText)) {
            this.dkk.setText(this.titleText);
            this.dvl.setVisibility(0);
        } else {
            this.dkk.setVisibility(8);
            this.dvl.setVisibility(8);
        }
        if (this.ltI != null) {
            this.dvm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ltI.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0671a {
        private View duT;
        private int duU;
        private int duV;
        private boolean duX;
        private a ltL;
        private c ltM;
        public boolean ltN;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0671a(a aVar) {
            this(null, aVar);
        }

        public C0671a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.duU = R.drawable.person_more_pop_item_bg_selector;
            this.duV = 17;
            this.duX = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0671a.this.ltM != null) {
                        C0671a.this.ltM.onClick();
                    }
                    if (C0671a.this.ltL != null && C0671a.this.ltL.deC() != null) {
                        C0671a.this.ltL.deC().k(C0671a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.ltL = aVar;
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
            this.ltM = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.ltN) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.kC(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.duT, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.ltL != null && this.ltL.getContext() != null) {
                this.mView = LayoutInflater.from(this.ltL.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.ltL.getView(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.duV);
                this.duT = this.mView.findViewById(R.id.divider_line);
                if (this.duX) {
                    this.duT.setVisibility(0);
                } else {
                    this.duT.setVisibility(8);
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
