package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public abstract class ResourceDragSortCursorAdapter extends DragSortCursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int f26516a;

    /* renamed from: b  reason: collision with root package name */
    public int f26517b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f26518c;

    @Deprecated
    public ResourceDragSortCursorAdapter(Context context, int i, Cursor cursor) {
        super(context, cursor);
        this.f26517b = i;
        this.f26516a = i;
        this.f26518c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f26518c.inflate(this.f26517b, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f26518c.inflate(this.f26516a, viewGroup, false);
    }

    public void setDropDownViewResource(int i) {
        this.f26517b = i;
    }

    public void setViewResource(int i) {
        this.f26516a = i;
    }

    public ResourceDragSortCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f26517b = i;
        this.f26516a = i;
        this.f26518c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceDragSortCursorAdapter(Context context, int i, Cursor cursor, int i2) {
        super(context, cursor, i2);
        this.f26517b = i;
        this.f26516a = i;
        this.f26518c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
