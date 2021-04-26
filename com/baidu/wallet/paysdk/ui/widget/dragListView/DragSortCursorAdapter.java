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
    public SparseIntArray f26950a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Integer> f26951b;

    public DragSortCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        this.f26950a = new SparseIntArray();
        this.f26951b = new ArrayList<>();
    }

    private void a() {
        this.f26950a.clear();
        this.f26951b.clear();
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        int size = this.f26950a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f26950a.keyAt(i2) == this.f26950a.valueAt(i2)) {
                arrayList.add(Integer.valueOf(this.f26950a.keyAt(i2)));
            }
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            this.f26950a.delete(((Integer) arrayList.get(i3)).intValue());
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public void changeCursor(Cursor cursor) {
        super.changeCursor(cursor);
        a();
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.b
    public void drag(int i2, int i3) {
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.h
    public void drop(int i2, int i3) {
        if (i2 != i3) {
            int i4 = this.f26950a.get(i2, i2);
            if (i2 > i3) {
                while (i2 > i3) {
                    SparseIntArray sparseIntArray = this.f26950a;
                    int i5 = i2 - 1;
                    sparseIntArray.put(i2, sparseIntArray.get(i5, i5));
                    i2--;
                }
            } else {
                while (i2 < i3) {
                    SparseIntArray sparseIntArray2 = this.f26950a;
                    int i6 = i2 + 1;
                    sparseIntArray2.put(i2, sparseIntArray2.get(i6, i6));
                    i2 = i6;
                }
            }
            this.f26950a.put(i3, i4);
            b();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount() - this.f26951b.size();
    }

    public int getCursorPosition(int i2) {
        return this.f26950a.get(i2, i2);
    }

    public ArrayList<Integer> getCursorPositions() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < getCount(); i2++) {
            arrayList.add(Integer.valueOf(this.f26950a.get(i2, i2)));
        }
        return arrayList;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return super.getDropDownView(this.f26950a.get(i2, i2), view, viewGroup);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public Object getItem(int i2) {
        return super.getItem(this.f26950a.get(i2, i2));
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public long getItemId(int i2) {
        return super.getItemId(this.f26950a.get(i2, i2));
    }

    public int getListPosition(int i2) {
        if (this.f26951b.contains(Integer.valueOf(i2))) {
            return -1;
        }
        int indexOfValue = this.f26950a.indexOfValue(i2);
        return indexOfValue < 0 ? i2 : this.f26950a.keyAt(indexOfValue);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return super.getView(this.f26950a.get(i2, i2), view, viewGroup);
    }

    @Override // com.baidu.wallet.paysdk.ui.widget.dragListView.DragSortListView.m
    public void remove(int i2) {
        int i3 = this.f26950a.get(i2, i2);
        if (!this.f26951b.contains(Integer.valueOf(i3))) {
            this.f26951b.add(Integer.valueOf(i3));
        }
        int count = getCount();
        while (i2 < count) {
            SparseIntArray sparseIntArray = this.f26950a;
            int i4 = i2 + 1;
            sparseIntArray.put(i2, sparseIntArray.get(i4, i4));
            i2 = i4;
        }
        this.f26950a.delete(count);
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
        this.f26950a = new SparseIntArray();
        this.f26951b = new ArrayList<>();
    }

    public DragSortCursorAdapter(Context context, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f26950a = new SparseIntArray();
        this.f26951b = new ArrayList<>();
    }
}
