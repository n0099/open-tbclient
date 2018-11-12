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
    private TextView ajl;
    private b hFA;
    private Context hFv;
    private LinearLayout hFw;
    private View hFx;
    private TextView hFy;
    private d hFz;
    private List<C0320a> mItems;
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
        void hC(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hFv = context;
            this.view = LayoutInflater.from(context).inflate(e.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hFw = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.ajl = (TextView) this.view.findViewById(e.g.title);
            this.hFx = this.view.findViewById(e.g.title_divide_line);
            this.mItems = new ArrayList();
            this.hFy = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hFv;
    }

    public ViewGroup aiX() {
        return this.hFw;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hFz = dVar;
    }

    public d bJT() {
        return this.hFz;
    }

    public void dZ(List<C0320a> list) {
        if (list != null) {
            this.mItems = list;
            this.hFw.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0320a c0320a = list.get(i2);
                    if (c0320a != null) {
                        this.hFw.addView(c0320a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hFA = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.ajl, e.d.cp_bg_line_d);
        al.h(this.ajl, e.d.cp_cont_j);
        al.j(this.hFx, e.d.cp_bg_line_c);
        al.i(this.hFy, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hFy, e.d.cp_cont_f);
        if (this.mItems != null) {
            for (C0320a c0320a : this.mItems) {
                c0320a.onChangeSkinType();
            }
        }
    }

    public View bJU() {
        if (!StringUtils.isNull(this.titleText)) {
            this.ajl.setText(this.titleText);
        } else {
            this.ajl.setVisibility(8);
        }
        if (this.hFA != null) {
            this.hFy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hFA.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0320a {
        private View ekB;
        private a hFC;
        private int hFD;
        private int hFE;
        private c hFF;
        private boolean hFG;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private String mText;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0320a(a aVar) {
            this(null, aVar);
        }

        public C0320a(String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hFD = e.f.person_more_pop_item_bg_selector;
            this.hFE = 17;
            this.hFG = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0320a.this.hFF != null) {
                        C0320a.this.hFF.onClick();
                    }
                    if (C0320a.this.hFC != null && C0320a.this.hFC.bJT() != null) {
                        C0320a.this.hFC.bJT().hC(C0320a.this.mId);
                    }
                }
            };
            this.mText = str;
            this.hFC = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0320a(int i, String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hFD = e.f.person_more_pop_item_bg_selector;
            this.hFE = 17;
            this.hFG = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0320a.this.hFF != null) {
                        C0320a.this.hFF.onClick();
                    }
                    if (C0320a.this.hFC != null && C0320a.this.hFC.bJT() != null) {
                        C0320a.this.hFC.bJT().hC(C0320a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.mText = str;
            this.hFC = aVar;
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
            this.hFF = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_b);
            al.j(this.ekB, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hFC != null && this.hFC.getContext() != null) {
                this.mView = LayoutInflater.from(this.hFC.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hFC.aiX(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.mText);
                this.mTextView.setGravity(this.hFE);
                this.ekB = this.mView.findViewById(e.g.divider_line);
                if (this.hFG) {
                    this.ekB.setVisibility(0);
                } else {
                    this.ekB.setVisibility(8);
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
