package com.baidu.tieba.write.write.vote;

import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.z0.i0;
import java.util.List;
/* loaded from: classes5.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f22995a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f22996b;

    /* renamed from: d  reason: collision with root package name */
    public f f22998d;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22997c = false;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f22999e = new a(this);

    /* loaded from: classes5.dex */
    public class a implements TextView.OnEditorActionListener {
        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            View focusSearch;
            if (i2 != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                return true;
            }
            focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f23000e;

        public b(int i2) {
            this.f23000e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22998d != null) {
                WriteVoteViewAdapter.this.f22998d.a(this.f23000e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WriteVoteViewAdapter.this.f22998d != null) {
                WriteVoteViewAdapter.this.f22998d.b();
                WriteVoteViewAdapter.this.f22997c = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f23003a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f23004b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f23005c;

        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f23003a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f23004b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f23005c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public EditText f23006a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f23007b;

        /* renamed from: c  reason: collision with root package name */
        public g f23008c;

        /* loaded from: classes5.dex */
        public class a implements View.OnFocusChangeListener {
            public a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    e eVar = e.this;
                    eVar.f23006a.addTextChangedListener(eVar.f23008c);
                    return;
                }
                e eVar2 = e.this;
                eVar2.f23006a.removeTextChangedListener(eVar2.f23008c);
            }
        }

        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            this.f23006a = (EditText) view.findViewById(R.id.vote_item);
            this.f23007b = (ImageView) view.findViewById(R.id.img_delete);
            this.f23008c = new g(this);
            this.f23006a.setOnEditorActionListener(writeVoteViewAdapter.f22999e);
        }

        public void b(int i2) {
            this.f23008c.a(i2);
            this.f23006a.setOnFocusChangeListener(new a());
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i2);
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {

        /* renamed from: e  reason: collision with root package name */
        public final e f23010e;

        /* renamed from: f  reason: collision with root package name */
        public int f23011f;

        public g(e eVar) {
            this.f23010e = eVar;
        }

        public void a(int i2) {
            this.f23011f = i2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f23011f + 1);
            if (i0.d(replace) > 28) {
                WriteVoteViewAdapter.this.f22995a.showToast(String.format(WriteVoteViewAdapter.this.f22995a.getString(R.string.write_vote_toast), 14));
            }
            String m = i0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f23010e.f23006a.setText(m);
                this.f23010e.f23006a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            WriteVoteViewAdapter.this.f22998d.c(writeVoteItemData, this.f23011f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        this.f22995a = tbPageContext;
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f22995a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f22995a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f23006a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f23006a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f23006a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f23007b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f23003a, R.color.CAM_X0302);
            dVar.f23005c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f23004b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    public void g(f fVar) {
        this.f22998d = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<WriteVoteItemData> list = this.f22996b;
        if (list == null) {
            return 0;
        }
        if (list.size() < 20) {
            return this.f22996b.size() + 1;
        }
        return 20;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return !h(i2) ? 1 : 2;
    }

    public final boolean h(int i2) {
        List<WriteVoteItemData> list = this.f22996b;
        return list != null && list.size() < 20 && i2 == this.f22996b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            String text = this.f22996b.get(i2).getText();
            eVar.f23006a.setHint(String.format(this.f22995a.getString(R.string.write_vote_item), Integer.valueOf(i2 + 1)));
            eVar.f23006a.setGravity(19);
            if (i2 < this.f22996b.size() - 1) {
                eVar.f23006a.setImeOptions(5);
            } else {
                eVar.f23006a.setImeOptions(1);
            }
            ImageView imageView = eVar.f23007b;
            if (this.f22996b.size() > 2) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new b(i2));
            eVar.b(i2);
            if (!StringUtils.isNull(text)) {
                eVar.f23006a.setText(text);
            } else {
                eVar.f23006a.setText("");
            }
            if (this.f22997c && i2 == this.f22996b.size() - 1) {
                eVar.f23006a.requestFocus();
                this.f22997c = false;
            }
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            dVar.f23003a.setText(String.format(this.f22995a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f22996b.size())));
            dVar.f23005c.setOnClickListener(new c());
        }
        f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new e(this, LayoutInflater.from(this.f22995a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(this.f22995a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
    }

    public void setData(List<WriteVoteItemData> list) {
        this.f22996b = list;
        notifyDataSetChanged();
    }
}
