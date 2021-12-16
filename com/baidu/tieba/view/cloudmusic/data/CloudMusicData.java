package com.baidu.tieba.view.cloudmusic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes12.dex */
public class CloudMusicData extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MusicTagList> music_tag_list;
    public List<TagList> tag_list;

    /* loaded from: classes12.dex */
    public static class MusicTagList extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public List<MusicList> music_list;
        public Page page;
        public int tag_id;

        /* loaded from: classes12.dex */
        public static class MusicList extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 3;
            public transient /* synthetic */ FieldHolder $fh;
            public String author;
            public int duration;
            public String image;
            public boolean isLoading;
            public int music_id;
            public String name;
            public String resource;

            public MusicList() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.isLoading = false;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || MusicList.class != obj.getClass()) {
                        return false;
                    }
                    MusicList musicList = (MusicList) obj;
                    if (this.duration == musicList.duration && this.music_id == musicList.music_id) {
                        String str = this.name;
                        if (str == null ? musicList.name == null : str.equals(musicList.name)) {
                            String str2 = this.image;
                            if (str2 == null ? musicList.image == null : str2.equals(musicList.image)) {
                                String str3 = this.resource;
                                if (str3 == null ? musicList.resource == null : str3.equals(musicList.resource)) {
                                    String str4 = this.author;
                                    String str5 = musicList.author;
                                    return str4 != null ? str4.equals(str5) : str5 == null;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    String str = this.name;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    String str2 = this.image;
                    int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                    String str3 = this.resource;
                    int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                    String str4 = this.author;
                    return ((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.duration) * 31) + this.music_id;
                }
                return invokeV.intValue;
            }
        }

        /* loaded from: classes12.dex */
        public static class Page extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2;
            public transient /* synthetic */ FieldHolder $fh;
            public int has_more;
            public int pn;

            public Page() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public MusicTagList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class TagList extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public String name;

        public TagList() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public CloudMusicData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
