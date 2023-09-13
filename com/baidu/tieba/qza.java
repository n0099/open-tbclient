package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes7.dex */
public class qza extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wv4> a;
    public String b;
    public BaseFragmentActivity c;
    public int d;
    public LayoutInflater e;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public ImageView c;

        public b(qza qzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(qza qzaVar, a aVar) {
            this(qzaVar);
        }
    }

    public qza(BaseFragmentActivity baseFragmentActivity) {
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
        this.d = BdUtilHelper.getEquipmentWidth(this.c.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public wv4 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return (wv4) ListUtils.getItem(this.a, i);
        }
        return (wv4) invokeI.objValue;
    }

    public void b(List<wv4> list, String str) {
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
                view2 = this.e.inflate(R.layout.obfuscated_res_0x7f0d0126, viewGroup, false);
                bVar = new b(this, null);
                bVar.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911bc);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911ce);
                bVar.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911a8);
                bVar.a.setGifIconSupport(false);
                bVar.a.setLongIconSupport(false);
                view2.setTag(bVar);
            }
            wv4 item = getItem(i);
            if (item == null) {
                view2.setVisibility(4);
                return view2;
            }
            view2.setVisibility(0);
            if (!TextUtils.isEmpty(item.g())) {
                String textOmit = BdUtilHelper.getTextOmit(bVar.b.getPaint(), item.g(), this.d);
                bVar.b.setText(textOmit + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
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
                bVar.a.startLoad(((VideoFileInfo) f).videoPath, 37, false);
            } else if (f instanceof ImageFileInfo) {
                bVar.a.startLoad(((ImageFileInfo) f).getFilePath(), 35, false);
            }
            SkinManager.setViewTextColor(bVar.b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view2, R.drawable.addresslist_item_bg);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
