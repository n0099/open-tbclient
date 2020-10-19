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
/* loaded from: classes24.dex */
public class a {
    private String dPX;
    private SearchMajorActivity kvm;
    private com.baidu.tieba.majorsearch.a kvy;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.kvm = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.kvm).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.kvm.setContentView(this.mRootView);
        this.kvy = new com.baidu.tieba.majorsearch.a(this.mRootView, this.kvm);
        cWA();
        cWn();
        this.dPX = "";
        cWB();
    }

    public void cWA() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kvm.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cWB();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cWB();
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
                    a.this.dPX = editable.toString();
                    a.this.cWB();
                    a.this.kvy.nK(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.kvy.a(onFocusChangeListener);
        this.kvy.a(onEditorActionListener);
        this.kvy.d(textWatcher);
    }

    private void cWn() {
        a.InterfaceC0761a interfaceC0761a = new a.InterfaceC0761a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0761a
            public void Nr(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.kvm.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.kvm.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.kvy.a(interfaceC0761a);
        this.kvy.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWB() {
        if (this.kvm != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dPX != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dPX.trim());
                    this.kvm.sendMessage(httpMessage);
                }
            } else if (this.kvy != null) {
                d(new ErrorData());
                this.kvm.getRefreshView().rj(R.drawable.new_pic_emotion_05);
                this.kvm.showNetRefreshViewNoClick(this.kvy.cWx(), null);
                this.kvm.getRefreshView().Dw(this.kvm.getString(R.string.im_error_default));
            }
        }
    }

    public void eq(List<String> list) {
        if (this.kvy != null) {
            this.kvy.m(list, this.dPX);
        }
    }

    public void d(ErrorData errorData) {
        if (this.kvy != null) {
            this.kvy.c(errorData);
        }
    }

    public void onResume() {
        if (this.kvy != null) {
            this.kvy.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.kvy.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cWC() {
        return this.kvy;
    }
}
