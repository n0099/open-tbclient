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
    private TextView adB;
    private List<C0257a> anw;
    private View hwA;
    private TextView hwB;
    private d hwC;
    private b hwD;
    private Context hwy;
    private LinearLayout hwz;
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
        void ju(int i);
    }

    public a(Context context) {
        if (context != null) {
            this.hwy = context;
            this.view = LayoutInflater.from(context).inflate(e.h.bottom_up_list_dialog_view, (ViewGroup) null);
            this.hwz = (LinearLayout) this.view.findViewById(e.g.content_view);
            this.adB = (TextView) this.view.findViewById(e.g.title);
            this.hwA = this.view.findViewById(e.g.title_divide_line);
            this.anw = new ArrayList();
            this.hwB = (TextView) this.view.findViewById(e.g.dialog_bottom_cancel_button);
        }
    }

    public Context getContext() {
        return this.hwy;
    }

    public ViewGroup afQ() {
        return this.hwz;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public void a(d dVar) {
        this.hwC = dVar;
    }

    public d bHi() {
        return this.hwC;
    }

    public void dN(List<C0257a> list) {
        if (list != null) {
            this.anw = list;
            this.hwz.removeAllViews();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    C0257a c0257a = list.get(i2);
                    if (c0257a != null) {
                        this.hwz.addView(c0257a.getView());
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.hwD = bVar;
    }

    public void onChangeSkinType() {
        al.j(this.adB, e.d.cp_bg_line_d);
        al.h(this.adB, e.d.cp_cont_j);
        al.j(this.hwA, e.d.cp_bg_line_c);
        al.i(this.hwB, e.f.bg_bottom_up_list_dialog_item);
        al.h(this.hwB, e.d.cp_cont_f);
        if (this.anw != null) {
            for (C0257a c0257a : this.anw) {
                c0257a.onChangeSkinType();
            }
        }
    }

    public View bHj() {
        if (!StringUtils.isNull(this.titleText)) {
            this.adB.setText(this.titleText);
        } else {
            this.adB.setVisibility(8);
        }
        if (this.hwD != null) {
            this.hwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.view.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.hwD.onClick();
                }
            });
        }
        onChangeSkinType();
        return this.view;
    }

    /* renamed from: com.baidu.tieba.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0257a {
        private String aqV;
        private View ebn;
        private a hwF;
        private int hwG;
        private int hwH;
        private c hwI;
        private boolean hwJ;
        private int mId;
        private final View.OnClickListener mOnClickListener;
        private int mTextColor;
        private TextView mTextView;
        private View mView;

        public C0257a(a aVar) {
            this(null, aVar);
        }

        public C0257a(String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hwG = e.f.person_more_pop_item_bg_selector;
            this.hwH = 17;
            this.hwJ = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0257a.this.hwI != null) {
                        C0257a.this.hwI.onClick();
                    }
                    if (C0257a.this.hwF != null && C0257a.this.hwF.bHi() != null) {
                        C0257a.this.hwF.bHi().ju(C0257a.this.mId);
                    }
                }
            };
            this.aqV = str;
            this.hwF = aVar;
            this.mId = hashCode();
            initView();
            initListener();
        }

        public C0257a(int i, String str, a aVar) {
            this.mTextColor = e.f.person_more_pop_cancel_text_selector;
            this.hwG = e.f.person_more_pop_item_bg_selector;
            this.hwH = 17;
            this.hwJ = true;
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.view.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0257a.this.hwI != null) {
                        C0257a.this.hwI.onClick();
                    }
                    if (C0257a.this.hwF != null && C0257a.this.hwF.bHi() != null) {
                        C0257a.this.hwF.bHi().ju(C0257a.this.mId);
                    }
                }
            };
            this.mId = i;
            this.aqV = str;
            this.hwF = aVar;
            initView();
            initListener();
        }

        public View getView() {
            return this.mView;
        }

        public void setText(String str) {
            this.aqV = str;
            this.mTextView.setText(this.aqV);
        }

        public void a(c cVar) {
            this.hwI = cVar;
            initListener();
        }

        public void onChangeSkinType() {
            al.i(this.mTextView, e.f.bg_bottom_up_list_dialog_item);
            al.h(this.mTextView, e.d.cp_cont_b);
            al.j(this.ebn, e.d.cp_bg_line_c);
        }

        private void initView() {
            if (this.hwF != null && this.hwF.getContext() != null) {
                this.mView = LayoutInflater.from(this.hwF.getContext()).inflate(e.h.bottom_up_list_dialog_item, this.hwF.afQ(), false);
                this.mTextView = (TextView) this.mView.findViewById(e.g.item_view);
                this.mTextView.setText(this.aqV);
                this.mTextView.setGravity(this.hwH);
                this.ebn = this.mView.findViewById(e.g.divider_line);
                if (this.hwJ) {
                    this.ebn.setVisibility(0);
                } else {
                    this.ebn.setVisibility(8);
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
