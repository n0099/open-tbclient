package com.baidu.tieba.square.data;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class ForumInfoData extends AbstractImageProvider implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String avatar;
    public int forum_id;
    public String forum_name;
    public int is_like;
    public int mbr_inter_rank;
    public int member_count;
    public String slogan;
    public int thread_count;

    public ForumInfoData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.forum_name = "";
        this.forum_id = 0;
        this.avatar = "";
        this.slogan = "";
        this.member_count = 0;
        this.thread_count = 0;
        this.is_like = 0;
        this.mbr_inter_rank = 0;
    }
}
