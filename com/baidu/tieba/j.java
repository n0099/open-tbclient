package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.util.cc;
/* loaded from: classes.dex */
public abstract class j extends Fragment implements DialogInterface.OnClickListener, View.OnClickListener, View.OnLongClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    protected int a = -1;
    private com.baidu.tieba.util.u b;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.b = com.baidu.tieba.util.u.a();
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void a(String str) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str2 = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str2)) {
                this.b.a(str, 2000);
            } else {
                BdUtilHelper.a((Context) getActivity(), str);
            }
        }
    }

    public void a(int i) {
        if (getActivity() != null) {
            String name = getClass().getName();
            String str = String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".chat";
            if (name.startsWith(String.valueOf(getActivity().getApplicationContext().getPackageName()) + ".im") || name.startsWith(str)) {
                this.b.a(i, 2000);
            } else {
                BdUtilHelper.a((Context) getActivity(), i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (this.b != null) {
            this.b.c();
        }
        super.onResume();
        if (b()) {
            b(TiebaApplication.g().al());
            cc.a(getClass().getName());
        }
    }

    public void b(int i) {
        if (i != this.a) {
            this.a = i;
            c(this.a);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        this.b.b();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    public void c(int i) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public boolean onLongClick(View view) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
    }

    public void onClick(View view) {
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            onResume();
        } else {
            onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        return !isHidden();
    }
}
