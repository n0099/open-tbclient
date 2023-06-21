package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class p48 extends nn6<h48> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;
    public CellTopicLinearLayout j;
    public TextView k;
    public TbImageView l;
    public TextView m;
    public TextView n;
    public h48 o;

    @Override // com.baidu.tieba.nn6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01dd : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p48(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = 3;
        View h = h();
        this.j = (CellTopicLinearLayout) h.findViewById(R.id.obfuscated_res_0x7f0925aa);
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0925ae);
        this.l = (TbImageView) h.findViewById(R.id.obfuscated_res_0x7f0925ac);
        this.m = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0925ad);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0925ab);
        this.l.setRadius(wi.g(this.c, R.dimen.tbds10));
        this.l.setConrers(15);
        this.l.setPlaceHolder(2);
        this.j.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.nn6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) != null) || i == this.i) {
            return;
        }
        this.i = i;
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
        this.l.setSkinType(this.i);
        SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        h48 h48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && (h48Var = this.o) != null && h48Var.e != null) {
            TiebaStatic.log(new StatisticItem("c13354").param("tid", this.o.e.tid).param("topic_id", this.o.c).param("obj_locate", this.o.b));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.b.getPageActivity()).createFromThreadCfg(this.o.e, null, "", 18005, true, false, false);
            if (this.o.e.getForumData() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.o.e.getFid()));
                createFromThreadCfg.setForumName(this.o.e.getForum_name());
            } else {
                createFromThreadCfg.setForumId(this.o.e.getForumData().b());
                createFromThreadCfg.setForumName(this.o.e.getForumData().d());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nn6
    /* renamed from: r */
    public void i(h48 h48Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, h48Var) == null) && h48Var != null && h48Var.e != null) {
            this.o = h48Var;
            if (h48Var.a) {
                if (StringUtils.isNull(h48Var.d)) {
                    this.k.setText(R.string.obfuscated_res_0x7f0f168c);
                } else {
                    this.k.setText(h48Var.d);
                }
            }
            TextView textView = this.k;
            if (h48Var.a) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            String str = null;
            if (!ListUtils.isEmpty(h48Var.e.getMedias())) {
                Iterator<MediaData> it = h48Var.e.getMedias().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (!StringHelper.equals(str, this.l.getUrl())) {
                this.l.H();
            }
            this.l.N(str, 10, false);
            if (StringUtils.isNull(h48Var.e.getTitle())) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.m.setText(h48Var.e.getTitle());
            }
            this.n.setText(String.format(this.c.getString(R.string.obfuscated_res_0x7f0f1684), Integer.valueOf(h48Var.e.getReply_num())));
        }
    }
}
