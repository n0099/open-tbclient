package com.baidu.tieba.majorsearch.a;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.majorsearch.SearchMajorActivity;
import com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private String erD;
    private SearchMajorActivity lmD;
    private com.baidu.tieba.majorsearch.a lmP;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.lmD = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.lmD).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.lmD.setContentView(this.mRootView);
        this.lmP = new com.baidu.tieba.majorsearch.a(this.mRootView, this.lmD);
        dff();
        deQ();
        this.erD = "";
        dfg();
    }

    public void dff() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.a.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lmD.getPageContext().getPageActivity(), view);
                } else {
                    a.this.dfg();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.a.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.dfg();
                    return true;
                }
                return false;
            }
        };
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.majorsearch.a.a.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    a.this.erD = editable.toString();
                    a.this.dfg();
                    a.this.lmP.po(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.lmP.a(onFocusChangeListener);
        this.lmP.a(onEditorActionListener);
        this.lmP.d(textWatcher);
    }

    private void deQ() {
        SearchMajorResultItemAdapter.a aVar = new SearchMajorResultItemAdapter.a() { // from class: com.baidu.tieba.majorsearch.a.a.4
            @Override // com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter.a
            public void Oe(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.lmD.Z(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.a.a.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.lmD.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.lmP.a(aVar);
        this.lmP.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfg() {
        if (this.lmD != null) {
            if (j.isNetWorkAvailable()) {
                if (this.erD != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.erD.trim());
                    this.lmD.sendMessage(httpMessage);
                }
            } else if (this.lmP != null) {
                d(new ErrorData());
                this.lmD.getRefreshView().rp(R.drawable.new_pic_emotion_05);
                this.lmD.showNetRefreshViewNoClick(this.lmP.dfc(), null);
                this.lmD.getRefreshView().Dr(this.lmD.getString(R.string.im_error_default));
            }
        }
    }

    public void eQ(List<String> list) {
        if (this.lmP != null) {
            this.lmP.o(list, this.erD);
        }
    }

    public void d(ErrorData errorData) {
        if (this.lmP != null) {
            this.lmP.c(errorData);
        }
    }

    public void onResume() {
        if (this.lmP != null) {
            this.lmP.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.lmP.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a dfh() {
        return this.lmP;
    }
}
