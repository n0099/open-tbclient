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
/* loaded from: classes11.dex */
public class a {
    private String dlV;
    private com.baidu.tieba.majorsearch.a jzE;
    private SearchMajorActivity jzs;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.jzs = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.jzs).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.jzs.setContentView(this.mRootView);
        this.jzE = new com.baidu.tieba.majorsearch.a(this.mRootView, this.jzs);
        cAw();
        cAj();
        this.dlV = "";
        cAx();
    }

    public void cAw() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.jzs.getPageContext().getPageActivity(), view);
                } else {
                    a.this.cAx();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.cAx();
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
                    a.this.dlV = editable.toString();
                    a.this.cAx();
                    a.this.jzE.lP(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.jzE.a(onFocusChangeListener);
        this.jzE.a(onEditorActionListener);
        this.jzE.d(textWatcher);
    }

    private void cAj() {
        a.InterfaceC0684a interfaceC0684a = new a.InterfaceC0684a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0684a
            public void Is(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.jzs.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.jzs.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.jzE.a(interfaceC0684a);
        this.jzE.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAx() {
        if (this.jzs != null) {
            if (j.isNetWorkAvailable()) {
                if (this.dlV != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.dlV.trim());
                    this.jzs.sendMessage(httpMessage);
                }
            } else if (this.jzE != null) {
                d(new ErrorData());
                this.jzs.getRefreshView().nR(R.drawable.new_pic_emotion_05);
                this.jzs.showNetRefreshViewNoClick(this.jzE.cAt(), null);
                this.jzs.getRefreshView().yQ(this.jzs.getString(R.string.im_error_default));
            }
        }
    }

    public void dQ(List<String> list) {
        if (this.jzE != null) {
            this.jzE.k(list, this.dlV);
        }
    }

    public void d(ErrorData errorData) {
        if (this.jzE != null) {
            this.jzE.c(errorData);
        }
    }

    public void onResume() {
        if (this.jzE != null) {
            this.jzE.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.jzE.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a cAy() {
        return this.jzE;
    }
}
