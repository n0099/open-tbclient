package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class p1a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<os4> a;
    public String b;
    public BaseFragmentActivity c;
    public int d;
    public LayoutInflater e;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public ImageView c;

        public b(p1a p1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(p1a p1aVar, a aVar) {
            this(p1aVar);
        }
    }

    public p1a(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = baseFragmentActivity;
        this.e = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.d = ii.l(this.c.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public os4 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (os4) ListUtils.getItem(this.a, i);
        }
        return (os4) invokeI.objValue;
    }

    public void b(List<os4> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.a = list;
            this.b = str;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ListUtils.getCount(this.a);
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            if (view2 != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
            } else {
                view2 = this.e.inflate(R.layout.obfuscated_res_0x7f0d011c, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091112);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091123);
                bVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0910ff);
                bVar.a.setGifIconSupport(false);
                bVar.a.setLongIconSupport(false);
                view2.setTag(bVar);
            }
            os4 item = getItem(i);
            if (item == null) {
                view2.setVisibility(4);
                return view2;
            }
            view2.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String v = ii.v(bVar.b.getPaint(), item.g(), this.d);
                bVar.b.setText(v + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
            } else {
                bVar.b.setText("");
            }
            String b2 = item.b();
            if (!TextUtils.isEmpty(b2) && b2.equals(this.b)) {
                bVar.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                bVar.c.setVisibility(0);
            } else {
                bVar.c.setVisibility(8);
            }
            MediaFileInfo f = item.f();
            if (f instanceof VideoFileInfo) {
                bVar.a.N(((VideoFileInfo) f).videoPath, 37, false);
            } else if (f instanceof ImageFileInfo) {
                bVar.a.N(((ImageFileInfo) f).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
