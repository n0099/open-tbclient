package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.df;
import com.baidu.tieba.kv4;
import com.baidu.tieba.r9;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ForumListModel extends BdBaseModel<ForumListActivity> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY = "_list";
    public static boolean isOk = false;
    public static String menu_name = null;
    public static final long serialVersionUID = -5006585496963439439L;
    public transient /* synthetic */ FieldHolder $fh;
    public long ctime;
    public ForumInfoData[] editor_recommend;
    public int error_code;
    public String[] forum_class;
    public long logid;
    public List recommend_list_left;
    public List recommend_list_right;
    public long time;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1028157534, "Lcom/baidu/tieba/square/flist/ForumListModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1028157534, "Lcom/baidu/tieba/square/flist/ForumListModel;");
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static class List extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3206282936395220632L;
        public transient /* synthetic */ FieldHolder $fh;
        public ForumInfoData[] forum_list;
        public int has_more;

        public List() {
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
            this.has_more = 0;
        }
    }

    /* loaded from: classes6.dex */
    public static class RequestParams extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8487620337266534315L;
        public transient /* synthetic */ FieldHolder $fh;
        public String level_2_name;
        public int menu_id;
        public String menu_name;
        public int menu_type;
        public int offset;
        public int parent_menu_id;
        public String parent_menu_name;
        public int recommend_type;
        public int rn;

        public RequestParams() {
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
            this.rn = 6;
            this.offset = 0;
            this.recommend_type = 0;
            this.menu_name = "";
            this.menu_id = 0;
            this.menu_type = 0;
            this.parent_menu_name = "";
            this.parent_menu_id = 0;
            this.level_2_name = "";
        }
    }

    public ForumListModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
    }

    public boolean isOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return isOk;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumListModel(TbPageContext<ForumListActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.time = 0L;
        this.ctime = 0L;
        this.logid = 0L;
    }

    public static ForumListModel new_fetch(RequestParams requestParams) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, requestParams)) == null) {
            if (requestParams.menu_id == 0) {
                if (requestParams.menu_name.equals(requestParams.parent_menu_name)) {
                    i = 9;
                } else {
                    i = 10;
                }
            } else if (requestParams.menu_type != 2 && requestParams.menu_name.equals(requestParams.parent_menu_name)) {
                i = 136;
            } else {
                i = Cea708Decoder.COMMAND_DSW;
            }
            menu_name = requestParams.menu_name;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumrank");
            netWork.addPostData("rn", String.valueOf(requestParams.rn));
            netWork.addPostData("offset", String.valueOf(requestParams.offset));
            netWork.addPostData("recommend_type", String.valueOf(requestParams.recommend_type));
            netWork.addPostData("menu_name", requestParams.menu_name);
            netWork.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, String.valueOf(i));
            String postNetData = netWork.postNetData();
            isOk = netWork.isNetSuccess();
            ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(postNetData, ForumListModel.class);
            if (requestParams.rn == 200 && requestParams.recommend_type == 0 && ((i == 9 || i == 136 || requestParams.menu_type == 2) && forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null)) {
                kv4.f();
                df<String> g = kv4.g("tb.my_posts");
                if (g != null) {
                    g.e(TbadkCoreApplication.getCurrentAccount() + "_" + menu_name + KEY, postNetData, 86400000L);
                }
            }
            return forumListModel;
        }
        return (ForumListModel) invokeL.objValue;
    }
}
