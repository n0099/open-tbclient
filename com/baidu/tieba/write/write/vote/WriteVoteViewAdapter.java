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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class WriteVoteViewAdapter extends RecyclerView.Adapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59217a;

    /* renamed from: b  reason: collision with root package name */
    public List<WriteVoteItemData> f59218b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59219c;

    /* renamed from: d  reason: collision with root package name */
    public f f59220d;

    /* renamed from: e  reason: collision with root package name */
    public TextView.OnEditorActionListener f59221e;

    /* loaded from: classes8.dex */
    public class a implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(WriteVoteViewAdapter writeVoteViewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            View focusSearch;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 != 5 || (focusSearch = textView.focusSearch(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER)) == null) {
                    return true;
                }
                focusSearch.requestFocus(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f59222e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f59223f;

        public b(WriteVoteViewAdapter writeVoteViewAdapter, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59223f = writeVoteViewAdapter;
            this.f59222e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59223f.f59220d == null) {
                return;
            }
            this.f59223f.f59220d.a(this.f59222e);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f59224e;

        public c(WriteVoteViewAdapter writeVoteViewAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59224e = writeVoteViewAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59224e.f59220d == null) {
                return;
            }
            this.f59224e.f59220d.b();
            this.f59224e.f59219c = true;
        }
    }

    /* loaded from: classes8.dex */
    public class d extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f59225a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59226b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f59227c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59225a = (TextView) view.findViewById(R.id.vote_add_item);
            this.f59226b = (ImageView) view.findViewById(R.id.vote_add_item_icon);
            this.f59227c = (RelativeLayout) view.findViewById(R.id.vote_add_item_back);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EditText f59228a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59229b;

        /* renamed from: c  reason: collision with root package name */
        public g f59230c;

        /* loaded from: classes8.dex */
        public class a implements View.OnFocusChangeListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f59231e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59231e = eVar;
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                    if (z) {
                        e eVar = this.f59231e;
                        eVar.f59228a.addTextChangedListener(eVar.f59230c);
                        return;
                    }
                    e eVar2 = this.f59231e;
                    eVar2.f59228a.removeTextChangedListener(eVar2.f59230c);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WriteVoteViewAdapter writeVoteViewAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59228a = (EditText) view.findViewById(R.id.vote_item);
            this.f59229b = (ImageView) view.findViewById(R.id.img_delete);
            this.f59230c = new g(writeVoteViewAdapter, this);
            this.f59228a.setOnEditorActionListener(writeVoteViewAdapter.f59221e);
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f59230c.a(i2);
                this.f59228a.setOnFocusChangeListener(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void a(int i2);

        void b();

        void c(WriteVoteItemData writeVoteItemData, int i2);
    }

    /* loaded from: classes8.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final e f59232e;

        /* renamed from: f  reason: collision with root package name */
        public int f59233f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ WriteVoteViewAdapter f59234g;

        public g(WriteVoteViewAdapter writeVoteViewAdapter, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {writeVoteViewAdapter, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59234g = writeVoteViewAdapter;
            this.f59232e = eVar;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f59233f = i2;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                obj = "";
            }
            String replace = obj.replace(" ", "");
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(this.f59233f + 1);
            if (m0.d(replace) > 28) {
                this.f59234g.f59217a.showToast(String.format(this.f59234g.f59217a.getString(R.string.write_vote_toast), 14));
            }
            String m = m0.m(replace, 28);
            if (!m.equals(editable.toString())) {
                this.f59232e.f59228a.setText(m);
                this.f59232e.f59228a.setSelection(m.length());
            }
            writeVoteItemData.setText(m);
            this.f59234g.f59220d.c(writeVoteItemData, this.f59233f);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048579, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    public WriteVoteViewAdapter(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59219c = false;
        this.f59221e = new a(this);
        this.f59217a = tbPageContext;
    }

    public final boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<WriteVoteItemData> list = this.f59218b;
            return list != null && list.size() < 20 && i2 == this.f59218b.size();
        }
        return invokeI.booleanValue;
    }

    public List<WriteVoteItemData> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59218b : (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<WriteVoteItemData> list = this.f59218b;
            if (list == null) {
                return 0;
            }
            if (list.size() < 20) {
                return this.f59218b.size() + 1;
            }
            return 20;
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? !d(i2) ? 1 : 2 : invokeI.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, viewHolder, i2) == null) {
            if (viewHolder instanceof e) {
                e eVar = (e) viewHolder;
                String text = this.f59218b.get(i2).getText();
                eVar.f59228a.setHint(String.format(this.f59217a.getString(R.string.write_vote_item), Integer.valueOf(i2 + 1)));
                eVar.f59228a.setGravity(19);
                if (i2 < this.f59218b.size() - 1) {
                    eVar.f59228a.setImeOptions(5);
                } else {
                    eVar.f59228a.setImeOptions(1);
                }
                ImageView imageView = eVar.f59229b;
                if (this.f59218b.size() > 2) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                imageView.setOnClickListener(new b(this, i2));
                eVar.b(i2);
                if (!StringUtils.isNull(text)) {
                    eVar.f59228a.setText(text);
                } else {
                    eVar.f59228a.setText("");
                }
                if (this.f59219c && i2 == this.f59218b.size() - 1) {
                    eVar.f59228a.requestFocus();
                    this.f59219c = false;
                }
            } else if (viewHolder instanceof d) {
                d dVar = (d) viewHolder;
                dVar.f59225a.setText(String.format(this.f59217a.getString(R.string.write_add_vote_item), Integer.valueOf(20 - this.f59218b.size())));
                dVar.f59227c.setOnClickListener(new c(this));
            }
            onChangeSkinType(viewHolder);
        }
    }

    public void onChangeSkinType(RecyclerView.ViewHolder viewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, viewHolder) == null) || viewHolder == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f59217a.getResources().getDimension(R.dimen.tbds10));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
        gradientDrawable.setStroke(l.g(this.f59217a.getPageActivity(), R.dimen.tbds1), SkinManager.getColor(R.color.CAM_X0603));
        if (viewHolder instanceof e) {
            e eVar = (e) viewHolder;
            eVar.f59228a.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            eVar.f59228a.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            eVar.f59228a.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(eVar.f59229b, R.drawable.ic_icon_mask_select_delete24_svg, SvgManager.SvgResourceStateType.NORMAL);
        } else if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            SkinManager.setViewTextColor(dVar.f59225a, R.color.CAM_X0302);
            dVar.f59227c.setBackgroundDrawable(gradientDrawable);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(dVar.f59226b, R.drawable.ic_icon_pure_post_addvote12_svg, R.color.CAM_X0302, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i2)) == null) {
            if (i2 == 1) {
                return new e(this, LayoutInflater.from(this.f59217a.getPageActivity()).inflate(R.layout.view_vote_item, viewGroup, false));
            }
            return new d(this, LayoutInflater.from(this.f59217a.getPageActivity()).inflate(R.layout.view_vote_add_item, viewGroup, false));
        }
        return (RecyclerView.ViewHolder) invokeLI.objValue;
    }

    public void setData(List<WriteVoteItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f59218b = list;
            notifyDataSetChanged();
        }
    }

    public void setOnVoteItemListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) {
            this.f59220d = fVar;
        }
    }
}
