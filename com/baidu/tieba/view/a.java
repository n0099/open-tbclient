package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView abu;
    private TextView hnA;
    private d hnB;
    private b hnC;
    private Context hnx;
    private LinearLayout hny;
    private View hnz;
    private List<C0251a> mItems;
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
        void onItemClick(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hnx = context;
            this.view = LayoutInflater.from(context).inflate(d.i.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hny = (LinearLayout) this.view.findViewById(d.g.content_view);
            this.abu = (TextView) this.view.findViewById(d.g.title);
            this.hnz = this.view.findViewById(d.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hnA = (TextView) this.view.findViewById(d.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hnx;
    }

    public ViewGroup adO() {
        return this.hny;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hnB = dVar;
    }

    public d bFE() {
        return this.hnB;
    }

    public void dQ(List<C0251a> list) {
        if (list != null) {
            this.mItems = list;
            this.hny.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0251a c0251a = list.get(i2);
                    if (c0251a != null) {
                        this.hny.addView(c0251a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hnC = bVar;
    }

    public void onChangeSkinType() {
        am.j(this.abu, d.C0142d.cp_bg_line_d);
        am.h(this.abu, d.C0142d.cp_cont_j);
        am.j(this.hnz, d.C0142d.cp_bg_line_c);
        am.i(this.hnA, d.f.bg_bottom_up_list_dialog_item);
        am.h(this.hnA, d.C0142d.cp_cont_f);
        if (this.mItems != null) {
            for (C0251a c0251a : this.mItems) {
                c0251a.onChangeSkinType();
            }
        }
    }

    public View bFF() {
        if (!StringUtils.isNull(this.titleText)) {
            this.abu.setText(this.titleText);
        } else {
            this.abu.setVisibility(8);
        }
        if (this.hnC != null) {
            this.hnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hnC.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0251a {
        private String aoM;
        private View dRm;
        private a hnE;
        private int hnF;
        private int hnG;
        private c hnH;
        private boolean hnI;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0251a(a aVar) {
            this(null, aVar);
        }

        public C0251a(String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hnF = d.f.person_more_pop_item_bg_selector;
            this.hnG = 17;
            this.hnI = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0251a.this.hnH != null) {
                        C0251a.this.hnH.onClick();
                    }
                    if (C0251a.this.hnE != null && C0251a.this.hnE.bFE() != null) {
                        C0251a.this.hnE.bFE().onItemClick(C0251a.this.mId);
                    }
                }
            };
            this.aoM = str;
            this.hnE = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0251a(int i, String str, a aVar) {
            this.mTextColor = d.f.person_more_pop_cancel_text_selector;
            this.hnF = d.f.person_more_pop_item_bg_selector;
            this.hnG = 17;
            this.hnI = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0251a.this.hnH != null) {
                        C0251a.this.hnH.onClick();
                    }
                    if (C0251a.this.hnE != null && C0251a.this.hnE.bFE() != null) {
                        C0251a.this.hnE.bFE().onItemClick(C0251a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aoM = str;
            this.hnE = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aoM = str;
            this.mTextView.setText(this.aoM);
        }

        public void a(c cVar) {
            this.hnH = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            am.i(this.mTextView, d.f.bg_bottom_up_list_dialog_item);
            am.h(this.mTextView, d.C0142d.cp_cont_b);
            am.j(this.dRm, d.C0142d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hnE != null && this.hnE.getContext() != null) {
                this.mView = LayoutInflater.from(this.hnE.getContext()).inflate(d.i.bottom_up_list_dialog_item, this.hnE.adO(), false);
                this.mTextView = (TextView) this.mView.findViewById(d.g.item_view);
                this.mTextView.setText(this.aoM);
                this.mTextView.setGravity(this.hnG);
                this.dRm = this.mView.findViewById(d.g.divider_line);
                if (this.hnI) {
                    this.dRm.setVisibility(0);
                } else {
                    this.dRm.setVisibility(8);
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
