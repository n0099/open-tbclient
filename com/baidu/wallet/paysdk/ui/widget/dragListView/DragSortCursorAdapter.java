package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.cursoradapter.widget.CursorAdapter;
import com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class DragSortCursorAdapter extends CursorAdapter implements DragSortListView.e {
    public static final int REMOVED = -1;

    /* renamed from: a  reason: collision with root package name */
    public SparseIntArray f26459a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f26460b;

    public DragSortCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.f26459a = new SparseIntArray();
        this.f26460b = new ArrayList<>();
    }

    private void a() {
        this.f26459a.clear();
        this.f26460b.clear();
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        int size = this.f26459a.size();
        for (int i = 0; i < size; i++) {
            if (this.f26459a.keyAt(i) == this.f26459a.valueAt(i)) {
                arrayList.add(Integer.valueOf(this.f26459a.keyAt(i)));
            }
        }
        int size2 = arrayList.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.f26459a.delete(((Integer) arrayList.get(i2)).intValue());
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.b
    public void drag(int i, int i2) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.h
    public void drop(int i, int i2) {
        if (i != i2) {
            int i3 = this.f26459a.get(i, i);
            if (i > i2) {
                while (i > i2) {
                    SparseIntArray sparseIntArray = this.f26459a;
                    int i4 = i - 1;
                    sparseIntArray.put(i, sparseIntArray.get(i4, i4));
                    i--;
                }
            } else {
                while (i < i2) {
                    SparseIntArray sparseIntArray2 = this.f26459a;
                    int i5 = i + 1;
                    sparseIntArray2.put(i, sparseIntArray2.get(i5, i5));
                    i = i5;
                }
            }
            this.f26459a.put(i2, i3);
            b();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() - this.f26460b.size();
    }

    public int getCursorPosition(int i) {
        return this.f26459a.get(i, i);
    }

    public ArrayList<Integer> getCursorPositions() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < getCount(); i++) {
            arrayList.add(Integer.valueOf(this.f26459a.get(i, i)));
        }
        return arrayList;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return super.getDropDownView(this.f26459a.get(i, i), view, viewGroup);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i) {
        return super.getItem(this.f26459a.get(i, i));
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return super.getItemId(this.f26459a.get(i, i));
    }

    public int getListPosition(int i) {
        if (this.f26460b.contains(Integer.valueOf(i))) {
            return -1;
        }
        int indexOfValue = this.f26459a.indexOfValue(i);
        return indexOfValue < 0 ? i : this.f26459a.keyAt(indexOfValue);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return super.getView(this.f26459a.get(i, i), view, viewGroup);
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.m
    public void remove(int i) {
        int i2 = this.f26459a.get(i, i);
        if (!this.f26460b.contains(Integer.valueOf(i2))) {
            this.f26460b.add(Integer.valueOf(i2));
        }
        int count = getCount();
        while (i < count) {
            SparseIntArray sparseIntArray = this.f26459a;
            int i3 = i + 1;
            sparseIntArray.put(i, sparseIntArray.get(i3, i3));
            i = i3;
        }
        this.f26459a.delete(count);
        b();
        notifyDataSetChanged();
    }

    public void reset() {
        a();
        notifyDataSetChanged();
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        Cursor swapCursor = super.swapCursor(cursor);
        a();
        return swapCursor;
    }

    public DragSortCursorAdapter(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f26459a = new SparseIntArray();
        this.f26460b = new ArrayList<>();
    }

    public DragSortCursorAdapter(Context context, Cursor cursor, int i) {
        super(context, cursor, i);
        this.f26459a = new SparseIntArray();
        this.f26460b = new ArrayList<>();
    }
}
