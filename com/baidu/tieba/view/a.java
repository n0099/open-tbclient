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
    private TextView bUf;
    private Context ceY;
    private LinearLayout cfa;
    private View cfb;
    private TextView cfc;
    private d jIT;
    private b jIU;
    private boolean jIV;
    private List<C0537a> mItems;
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
            this.ceY = context;
            this.view = LayoutInflater.from(context).inflate(R.layout.bottom_up_list_dialog_view, (ViewGroup) null);
            this.cfa = (LinearLayout) this.view.findViewById(R.id.content_view);
            this.bUf = (TextView) this.view.findViewById(R.id.title);
            this.cfb = this.view.findViewById(R.id.title_divide_line);
            this.mItems = new ArrayList();
            this.cfc = (TextView) this.view.findViewById(R.id.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.ceY;
    }

    public ViewGroup ala() {
        return this.cfa;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public d cwM() {
        return this.jIT;
    }

    public void at(List<C0537a> list) {
        if (list != null) {
            this.mItems = list;
            this.cfa.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0537a c0537a = list.get(i2);
                    if (c0537a != null) {
                        this.cfa.addView(c0537a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.jIU = bVar;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.view, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.bUf, R.drawable.bg_title_corner_dialog_item);
        am.setViewTextColor(this.bUf, (int) R.color.cp_cont_c);
        am.setBackgroundColor(this.cfb, R.color.cp_bg_line_c);
        am.setBackgroundResource(this.cfc, R.drawable.bg_bottom_up_list_dialog_item);
        am.setViewTextColor(this.cfc, (int) R.color.cp_cont_j);
        if (this.mItems != null) {
            for (C0537a c0537a : this.mItems) {
                c0537a.onChangeSkinType();
            }
        }
        if (this.jIV) {
            if (!StringUtils.isNull(this.titleText) && this.bUf != null && (this.bUf.getBackground() instanceof GradientDrawable)) {
                float dimension = getContext().getResources().getDimension(R.dimen.tbds32);
                ((GradientDrawable) this.bUf.getBackground()).setCornerRadii(new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f});
            } else if (v.getCount(this.mItems) > 0) {
                C0537a c0537a2 = this.mItems.get(0);
                if (!c0537a2.jIZ) {
                    c0537a2.jIZ = true;
                    c0537a2.onChangeSkinType();
                }
            }
        }
    }

    public View alc() {
        if (!StringUtils.isNull(this.titleText)) {
            this.bUf.setText(this.titleText);
            this.cfb.setVisibility(0);
        } else {
            this.bUf.setVisibility(8);
            this.cfb.setVisibility(8);
        }
        if (this.jIU != null) {
            this.cfc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jIU.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0537a {
        private View ceJ;
        private int ceK;
        private int ceL;
        private boolean ceN;
        private a jIX;
        private c jIY;
        public boolean jIZ;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        public TextView mTextView;
        private View mView;

        public C0537a(a aVar) {
            this(null, aVar);
        }

        public C0537a(String str, a aVar) {
            this.mTextColor = R.drawable.person_more_pop_cancel_text_selector;
            this.ceK = R.drawable.person_more_pop_item_bg_selector;
            this.ceL = 17;
            this.ceN = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0537a.this.jIY != null) {
                        C0537a.this.jIY.onClick();
                    }
                    if (C0537a.this.jIX != null && C0537a.this.jIX.cwM() != null) {
                        C0537a.this.jIX.cwM().m(C0537a.this.mId, view);
                    }
                }
            };
            this.mText = str;
            this.jIX = aVar;
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
            this.jIY = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            if (this.mTextView != null) {
                if (this.jIZ) {
                    am.setBackgroundResource(this.mTextView, R.drawable.bg_bottom_up_corner_dialog);
                } else {
                    this.mTextView.setBackgroundDrawable(am.is(R.color.cp_bg_line_k));
                }
            }
            am.setViewTextColor(this.mTextView, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_c);
        }

        private void initView() {
            if (this.jIX != null && this.jIX.getContext() != null) {
                this.mView = LayoutInflater.from(this.jIX.getContext()).inflate(R.layout.bottom_up_list_dialog_item, this.jIX.ala(), false);
                this.mTextView = (TextView) this.mView.findViewById(R.id.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.ceL);
                this.ceJ = this.mView.findViewById(R.id.divider_line);
                if (this.ceN) {
                    this.ceJ.setVisibility(0);
                } else {
                    this.ceJ.setVisibility(8);
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
