package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private TextView anp;
    private Context hQY;
    private LinearLayout hQZ;
    private View hRa;
    private TextView hRb;
    private d hRc;
    private b hRd;
    private List<C0333a> mItems;
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
        void hR(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hQY = context;
            this.view = LayoutInflater.from(context).inflate(e.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hQZ = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.anp = (TextView) this.view.findViewById(e.g.title);
            this.hRa = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hRb = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hQY;
    }

    public ViewGroup akV() {
        return this.hQZ;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hRc = dVar;
    }

    public d bNv() {
        return this.hRc;
    }

    public void ef(List<C0333a> list) {
        if (list != null) {
            this.mItems = list;
            this.hQZ.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0333a c0333a = list.get(i2);
                    if (c0333a != null) {
                        this.hQZ.addView(c0333a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hRd = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.anp, e.d.cp_bg_line_d);
        al.h(this.anp, e.d.cp_cont_j);
        al.j(this.hRa, e.d.cp_bg_line_c);
        al.i(this.hRb, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hRb, e.d.cp_cont_f);
        if (this.mItems != null) {
            for (C0333a c0333a : this.mItems) {
                c0333a.onChangeSkinType();
            }
        }
    }

    public View bNw() {
        if (!StringUtils.isNull(this.titleText)) {
            this.anp.setText(this.titleText);
        } else {
            this.anp.setVisibility(8);
        }
        if (this.hRd != null) {
            this.hRb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hRd.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0333a {
        private View euT;
        private a hRf;
        private int hRg;
        private int hRh;
        private c hRi;
        private boolean hRj;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0333a(a aVar) {
            this(null, aVar);
        }

        public C0333a(String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hRg = e.f.person_more_pop_item_bg_selector;
            this.hRh = 17;
            this.hRj = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0333a.this.hRi != null) {
                        C0333a.this.hRi.onClick();
                    }
                    if (C0333a.this.hRf != null && C0333a.this.hRf.bNv() != null) {
                        C0333a.this.hRf.bNv().hR(C0333a.this.mId);
                    }
                }
            };
            this.mText = str;
            this.hRf = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0333a(int i, String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hRg = e.f.person_more_pop_item_bg_selector;
            this.hRh = 17;
            this.hRj = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0333a.this.hRi != null) {
                        C0333a.this.hRi.onClick();
                    }
                    if (C0333a.this.hRf != null && C0333a.this.hRf.bNv() != null) {
                        C0333a.this.hRf.bNv().hR(C0333a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.mText = str;
            this.hRf = aVar;
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
            this.hRi = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_b);
            al.j(this.euT, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hRf != null && this.hRf.getContext() != null) {
                this.mView = LayoutInflater.from(this.hRf.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hRf.akV(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hRh);
                this.euT = this.mView.findViewById(e.g.divider_line);
                if (this.hRj) {
                    this.euT.setVisibility(0);
                } else {
                    this.euT.setVisibility(8);
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
