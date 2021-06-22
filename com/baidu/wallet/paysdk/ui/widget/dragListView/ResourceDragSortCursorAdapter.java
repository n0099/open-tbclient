package com.baidu.wallet.paysdk.ui.widget.dragListView;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes5.dex */
public abstract class ResourceDragSortCursorAdapter extends DragSortCursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    public int f26370a;

    /* renamed from: b  reason: collision with root package name */
    public int f26371b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f26372c;

    @Deprecated
    public ResourceDragSortCursorAdapter(Context context, int i2, Cursor cursor) {
        super(context, cursor);
        this.f26371b = i2;
        this.f26370a = i2;
        this.f26372c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f26372c.inflate(this.f26371b, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f26372c.inflate(this.f26370a, viewGroup, false);
    }

    public void setDropDownViewResource(int i2) {
        this.f26371b = i2;
    }

    public void setViewResource(int i2) {
        this.f26370a = i2;
    }

    public ResourceDragSortCursorAdapter(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f26371b = i2;
        this.f26370a = i2;
        this.f26372c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public ResourceDragSortCursorAdapter(Context context, int i2, Cursor cursor, int i3) {
        super(context, cursor, i3);
        this.f26371b = i2;
        this.f26370a = i2;
        this.f26372c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
