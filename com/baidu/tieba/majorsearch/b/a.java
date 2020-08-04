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
    private String drQ;
    private SearchMajorActivity jHY;
    private com.baidu.tieba.majorsearch.a jIk;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.jHY = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.jHY).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.jHY.setContentView(this.mRootView);
        this.jIk = new com.baidu.tieba.majorsearch.a(this.mRootView, this.jHY);
        cEt();
        cEg();
        this.drQ = "";
        cEu();
    }

    public void cEt() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jHY.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cEu();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cEu();
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
                    a.this.drQ = editable.toString();
                    a.this.cEu();
                    a.this.jIk.mu(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.jIk.a(onFocusChangeListener);
        this.jIk.a(onEditorActionListener);
        this.jIk.d(textWatcher);
    }

    private void cEg() {
        a.InterfaceC0695a interfaceC0695a = new a.InterfaceC0695a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0695a
            public void Jh(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.jHY.ab(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.jHY.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.jIk.a(interfaceC0695a);
        this.jIk.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
        if (this.jHY != null) {
            if (j.isNetWorkAvailable()) {
                if (this.drQ != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.drQ.trim());
                    this.jHY.sendMessage(httpMessage);
                }
            } else if (this.jIk != null) {
                d(new ErrorData());
                this.jHY.getRefreshView().oj(R.drawable.new_pic_emotion_05);
                this.jHY.showNetRefreshViewNoClick(this.jIk.cEq(), null);
                this.jHY.getRefreshView().zX(this.jHY.getString(R.string.im_error_default));
            }
        }
    }

    public void dX(List<String> list) {
        if (this.jIk != null) {
            this.jIk.l(list, this.drQ);
        }
    }

    public void d(ErrorData errorData) {
        if (this.jIk != null) {
            this.jIk.c(errorData);
        }
    }

    public void onResume() {
        if (this.jIk != null) {
            this.jIk.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.jIk.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cEv() {
        return this.jIk;
    }
}
