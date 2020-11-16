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
/* loaded from: classes23.dex */
public class a {
    private String ecD;
    private SearchMajorActivity kNS;
    private com.baidu.tieba.majorsearch.a kOe;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.kNS = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.kNS).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.kNS.setContentView(this.mRootView);
        this.kOe = new com.baidu.tieba.majorsearch.a(this.mRootView, this.kNS);
        dbH();
        dbu();
        this.ecD = "";
        dbI();
    }

    public void dbH() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.b.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.kNS.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dbI();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.b.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dbI();
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
                    a.this.ecD = editable.toString();
                    a.this.dbI();
                    a.this.kOe.on(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.kOe.a(onFocusChangeListener);
        this.kOe.a(onEditorActionListener);
        this.kOe.d(textWatcher);
    }

    private void dbu() {
        a.InterfaceC0793a interfaceC0793a = new a.InterfaceC0793a() { // from class: com.baidu.tieba.majorsearch.b.a.4
            @Override // com.baidu.tieba.majorsearch.a.a.InterfaceC0793a
            public void NC(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.kNS.aa(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.b.a.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.kNS.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.kOe.a(interfaceC0793a);
        this.kOe.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbI() {
        if (this.kNS != null) {
            if (j.isNetWorkAvailable()) {
                if (this.ecD != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.ecD.trim());
                    this.kNS.sendMessage(httpMessage);
                }
            } else if (this.kOe != null) {
                d(new ErrorData());
                this.kNS.getRefreshView().sc(R.drawable.new_pic_emotion_05);
                this.kNS.showNetRefreshViewNoClick(this.kOe.dbE(), null);
                this.kNS.getRefreshView().DC(this.kNS.getString(R.string.im_error_default));
            }
        }
    }

    public void eH(List<String> list) {
        if (this.kOe != null) {
            this.kOe.o(list, this.ecD);
        }
    }

    public void d(ErrorData errorData) {
        if (this.kOe != null) {
            this.kOe.c(errorData);
        }
    }

    public void onResume() {
        if (this.kOe != null) {
            this.kOe.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.kOe.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dbJ() {
        return this.kOe;
    }
}
