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
/* loaded from: classes8.dex */
public class a {
    private String eqb;
    private SearchMajorActivity lkn;
    private com.baidu.tieba.majorsearch.a lkz;
    private View mRootView;

    public a(SearchMajorActivity searchMajorActivity) {
        this.lkn = searchMajorActivity;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.lkn).inflate(R.layout.search_major_main, (ViewGroup) null);
        this.lkn.setContentView(this.mRootView);
        this.lkz = new com.baidu.tieba.majorsearch.a(this.mRootView, this.lkn);
        deP();
        deA();
        this.eqb = "";
        deQ();
    }

    public void deP() {
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.majorsearch.a.a.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    l.hideSoftKeyPad(a.this.lkn.getPageContext().getPageActivity(), view);
                } else {
                    a.this.deQ();
                }
            }
        };
        TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() { // from class: com.baidu.tieba.majorsearch.a.a.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 3) {
                    a.this.deQ();
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
                    a.this.eqb = editable.toString();
                    a.this.deQ();
                    a.this.lkz.po(!StringUtils.isNull(editable.toString()));
                }
            }
        };
        this.lkz.a(onFocusChangeListener);
        this.lkz.a(onEditorActionListener);
        this.lkz.d(textWatcher);
    }

    private void deA() {
        SearchMajorResultItemAdapter.a aVar = new SearchMajorResultItemAdapter.a() { // from class: com.baidu.tieba.majorsearch.a.a.4
            @Override // com.baidu.tieba.majorsearch.adapter.SearchMajorResultItemAdapter.a
            public void NX(String str) {
                Intent intent = new Intent();
                intent.putExtra(IntentConfig.SEARCH_MAJOR_NAME, str);
                a.this.lkn.Z(intent);
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.majorsearch.a.a.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(a.this.lkn.getPageContext().getPageActivity(), recyclerView);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            }
        };
        this.lkz.a(aVar);
        this.lkz.a(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deQ() {
        if (this.lkn != null) {
            if (j.isNetWorkAvailable()) {
                if (this.eqb != null) {
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_MAJOR);
                    httpMessage.addParam("keyword", this.eqb.trim());
                    this.lkn.sendMessage(httpMessage);
                }
            } else if (this.lkz != null) {
                d(new ErrorData());
                this.lkn.getRefreshView().ro(R.drawable.new_pic_emotion_05);
                this.lkn.showNetRefreshViewNoClick(this.lkz.deM(), null);
                this.lkn.getRefreshView().Dm(this.lkn.getString(R.string.im_error_default));
            }
        }
    }

    public void eQ(List<String> list) {
        if (this.lkz != null) {
            this.lkz.o(list, this.eqb);
        }
    }

    public void d(ErrorData errorData) {
        if (this.lkz != null) {
            this.lkz.c(errorData);
        }
    }

    public void onResume() {
        if (this.lkz != null) {
            this.lkz.onResume();
        }
    }

    public void onChangeSkinType(int i) {
        this.lkz.onChangeSkinType(i);
    }

    public com.baidu.tieba.majorsearch.a deR() {
        return this.lkz;
    }
}
