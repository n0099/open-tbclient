package com.baidu.tieba.majorsearch.b;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.a.a;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private String dBV;
    private com.baidu.tieba.majorsearch.a jXI;
    private SearchMajorActivity jXw;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.jXw = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.jXw).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.jXw.setContentView(this.mRootView);
        this.jXI = new com.baidu.tieba.majorsearch.a(this.mRootView, this.jXw);
        cPl();
        cOY();
        this.dBV = "";
        cPm();
    }

    public void cPl() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jXw.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cPm();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cPm();
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.majorsearch.b.a.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    a.this.dBV = editable.toString();
                    a.this.cPm();
                    a.this.jXI.mZ(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.jXI.a(onFocusChangeListener);
        this.jXI.a(onEditorActionListener);
        this.jXI.d(textWatcher);
    }

    private void cOY() {
        a.InterfaceC0746a interfaceC0746a = new a.InterfaceC0746a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0746a
            public void Ma(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.jXw.ad(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.jXw.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.jXI.a(interfaceC0746a);
        this.jXI.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPm() {
        if (this.jXw != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dBV != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dBV.trim());
                    this.jXw.sendMessage(httpMessage);
                }
            } else if (this.jXI != null) {
                d(new ErrorData());
                this.jXw.getRefreshView().qu(R.drawable.new_pic_emotion_05);
                this.jXw.showNetRefreshViewNoClick(this.jXI.cPi(), null);
                this.jXw.getRefreshView().Co(this.jXw.getString(R.string.im_error_default));
            }
        }
    }

    public void ef(List<String> list) {
        if (this.jXI != null) {
            this.jXI.l(list, this.dBV);
        }
    }

    public void d(ErrorData errorData) {
        if (this.jXI != null) {
            this.jXI.c(errorData);
        }
    }

    public void onResume() {
        if (this.jXI != null) {
            this.jXI.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.jXI.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cPn() {
        return this.jXI;
    }
}
