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
    private String dYu;
    private SearchMajorActivity kHJ;
    private com.baidu.tieba.majorsearch.a kHV;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.kHJ = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.kHJ).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.kHJ.setContentView(this.mRootView);
        this.kHV = new com.baidu.tieba.majorsearch.a(this.mRootView, this.kHJ);
        cZI();
        cZv();
        this.dYu = "";
        cZJ();
    }

    public void cZI() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kHJ.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cZJ();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cZJ();
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
                    a.this.dYu = editable.toString();
                    a.this.cZJ();
                    a.this.kHV.oc(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.kHV.a(onFocusChangeListener);
        this.kHV.a(onEditorActionListener);
        this.kHV.d(textWatcher);
    }

    private void cZv() {
        a.InterfaceC0776a interfaceC0776a = new a.InterfaceC0776a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0776a
            public void NP(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.kHJ.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.kHJ.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.kHV.a(interfaceC0776a);
        this.kHV.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZJ() {
        if (this.kHJ != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dYu != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dYu.trim());
                    this.kHJ.sendMessage(httpMessage);
                }
            } else if (this.kHV != null) {
                d(new ErrorData());
                this.kHJ.getRefreshView().ru(R.drawable.new_pic_emotion_05);
                this.kHJ.showNetRefreshViewNoClick(this.kHV.cZF(), null);
                this.kHJ.getRefreshView().DP(this.kHJ.getString(R.string.im_error_default));
            }
        }
    }

    public void ez(List<String> list) {
        if (this.kHV != null) {
            this.kHV.o(list, this.dYu);
        }
    }

    public void d(ErrorData errorData) {
        if (this.kHV != null) {
            this.kHV.c(errorData);
        }
    }

    public void onResume() {
        if (this.kHV != null) {
            this.kHV.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.kHV.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cZK() {
        return this.kHV;
    }
}
